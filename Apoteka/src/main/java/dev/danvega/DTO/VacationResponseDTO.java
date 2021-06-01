package dev.danvega.DTO;

public class VacationResponseDTO {

    private boolean answer;
    private String reason;
    private Long vacation_id;

    public VacationResponseDTO(boolean answer, String reason, Long vacation_id) {
        this.answer = answer;
        this.reason = reason;
        this.vacation_id = vacation_id;
    }

    public VacationResponseDTO() {
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getVacation_id() {
        return vacation_id;
    }

    public void setVacation_id(Long vacation_id) {
        this.vacation_id = vacation_id;
    }
}
