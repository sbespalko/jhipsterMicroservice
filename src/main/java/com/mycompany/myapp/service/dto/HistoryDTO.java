package com.mycompany.myapp.service.dto;
import java.time.Instant;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.mycompany.myapp.domain.History} entity.
 */
public class HistoryDTO implements Serializable {

    private Long id;

    private Instant startDt;

    private Instant endDt;

    private Integer riskPower;


    private Long clientId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getStartDt() {
        return startDt;
    }

    public void setStartDt(Instant startDt) {
        this.startDt = startDt;
    }

    public Instant getEndDt() {
        return endDt;
    }

    public void setEndDt(Instant endDt) {
        this.endDt = endDt;
    }

    public Integer getRiskPower() {
        return riskPower;
    }

    public void setRiskPower(Integer riskPower) {
        this.riskPower = riskPower;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        HistoryDTO historyDTO = (HistoryDTO) o;
        if (historyDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), historyDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "HistoryDTO{" +
            "id=" + getId() +
            ", startDt='" + getStartDt() + "'" +
            ", endDt='" + getEndDt() + "'" +
            ", riskPower=" + getRiskPower() +
            ", client=" + getClientId() +
            "}";
    }
}
