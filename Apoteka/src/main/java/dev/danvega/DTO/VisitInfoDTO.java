package dev.danvega.DTO;

public class VisitInfoDTO {
    private double price;
    private String report;
    private Long medicationID;

    private Long visitID;

    public VisitInfoDTO(double price, String report, Long medicationID, Long visitID) {
        this.price = price;
        this.report = report;
        this.medicationID = medicationID;
        this.visitID = visitID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Long getMedicationID() {
        return medicationID;
    }

    public void setMedicationID(Long medicationID) {
        this.medicationID = medicationID;
    }

    public Long getVisitID() {
        return visitID;
    }

    public void setVisitID(Long visitID) {
        this.visitID = visitID;
    }
}
