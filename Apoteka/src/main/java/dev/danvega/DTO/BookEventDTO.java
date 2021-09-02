package dev.danvega.DTO;

public class BookEventDTO {
    Long patId;
    Long eventId;
    String kategorija;

    public BookEventDTO() {
    }

    public BookEventDTO(Long patId, Long eventId, String kategorija) {
        this.patId = patId;
        this.eventId = eventId;
        this.kategorija = kategorija;
    }

    public Long getPatId() {
        return patId;
    }

    public void setPatId(Long patId) {
        this.patId = patId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }
}
