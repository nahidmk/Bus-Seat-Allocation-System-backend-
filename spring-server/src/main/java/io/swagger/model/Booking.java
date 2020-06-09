package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Booking
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-30T00:10:05.092Z")
@Entity
public class Booking extends AbstractEntity implements Cloneable  {

//  @Id
//  @JsonProperty("id")
//  private Long id = null;


  @JsonProperty("name")
  private String name = null;

  @JsonProperty("phone")
  private String phone = null;

  @JsonProperty("busNumber")
  private String busNumber = null;

  @JsonProperty("date")
  private LocalDate date = null;

  /**
   * Payment Types
   */

  @JsonProperty("paymentType")
  private String paymentType = null;

  @JsonProperty("seatNumber")
  private String seatNumber = null;

  public Booking name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Booking phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  **/
  @ApiModelProperty(value = "")


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Booking busNumber(String busNumber) {
    this.busNumber = busNumber;
    return this;
  }

  /**
   * Get busNumber
   * @return busNumber
  **/
  @ApiModelProperty(value = "")


  public String getBusNumber() {
    return busNumber;
  }

  public void setBusNumber(String busNumber) {
    this.busNumber = busNumber;
  }

  public Booking date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public Booking paymentType(String paymentType) {
    this.paymentType = paymentType;
    return this;
  }

  /**
   * Payment Types
   * @return paymentType
  **/
  @ApiModelProperty(value = "Payment Types")


  public String getPaymentType() {
    return paymentType;
  }

  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }

  public Booking seatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
    return this;
  }

  /**
   * Get seatNumber
   * @return seatNumber
  **/
  @ApiModelProperty(value = "")


  public String getSeatNumber() {
    return seatNumber;
  }

  public void setSeatNumber(String seatNumber) {
    this.seatNumber = seatNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Booking booking = (Booking) o;
    return Objects.equals(this.name, booking.name) &&
        Objects.equals(this.phone, booking.phone) &&
        Objects.equals(this.busNumber, booking.busNumber) &&
        Objects.equals(this.date, booking.date) &&
        Objects.equals(this.paymentType, booking.paymentType) &&
        Objects.equals(this.seatNumber, booking.seatNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, phone, busNumber, date, paymentType, seatNumber);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Booking {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    busNumber: ").append(toIndentedString(busNumber)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    paymentType: ").append(toIndentedString(paymentType)).append("\n");
    sb.append("    seatNumber: ").append(toIndentedString(seatNumber)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

