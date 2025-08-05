package school.hei.tsinjo.service;

@Service
public class VolaService {
  private static final Logger log = LoggerFactory.getLogger(VolaService.class);

  private final RestTemplate restTemplate = new RestTemplate();
  private final PaymentRepository paymentRepository;
  private final String baseUrl =
      "https://42cwka3n4ifcp7ufheyrpmph240iuaxo.lambda-url.eu-west-3.on.aws";

  @Value("${vola.api-key}")
  private String apiKey;

  public VolaService(PaymentRepository paymentRepository) {
    this.paymentRepository = paymentRepository;
  }

  public void updateVerifyingPayments() {
    List<Payment> verifyingPayments = paymentRepository.findByStatus(PaymentStatus.VERIFYING);

    for (Payment payment : verifyingPayments) {
      try {
        PaymentStatus newStatus = checkStatus(payment.getId());

        if (newStatus != PaymentStatus.VERIFYING) {
          payment.setStatus(newStatus);
          paymentRepository.update(payment);

          log.info("Payment {} status updated to {}", payment.getId(), newStatus);
        } else {
          log.debug("Payment {} still verifying", payment.getId());
        }

      } catch (Exception ex) {
        log.error("Failed to update payment {}: {}", payment.getId(), ex.getMessage());
      }
    }
  }

  public PaymentStatus checkStatus(UUID paymentId) {
    String url = baseUrl + "/payments/" + paymentId;

    HttpHeaders headers = new HttpHeaders();
    headers.set("X-API-Key", apiKey);

    HttpEntity<Void> request = new HttpEntity<>(headers);

    try {
      ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);

      if (response.getStatusCode().is2xxSuccessful()) {
        String status = (String) response.getBody().get("status");
        log.debug("Payment {} Vola status = {}", paymentId, status);
        return PaymentStatus.valueOf(status);
      } else {
        log.warn(
            "Unexpected status code {} from Vola for payment {}",
            response.getStatusCode(),
            paymentId);
        return PaymentStatus.VERIFYING;
      }
    } catch (Exception ex) {
      log.error("Error while checking payment status for {}: {}", paymentId, ex.getMessage());
      return PaymentStatus.VERIFYING;
    }
  }
}
