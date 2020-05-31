package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Bus
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-05-30T00:10:05.092Z")
@Entity
public class Bus   {

  @Id
  @JsonProperty("busNumber")
  private String busNumber = null;

  @JsonProperty("staffName")
  private String staffName = null;

  @JsonProperty("boardingPoing")
  private String boardingPoing = null;

  @JsonProperty("time")
  private String time = null;

  @JsonProperty("numberofSeatAreFree")
  private Integer numberofSeatAreFree = null;

  @JsonProperty("costPerSeat")
  private Integer costPerSeat = null;

  public Bus busNumber(String busNumber) {
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

  public Bus staffName(String staffName) {
    this.staffName = staffName;
    return this;
  }

  /**
   * Get staffName
   * @return staffName
  **/
  @ApiModelProperty(value = "")


  public String getStaffName() {
    return staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public Bus boardingPoing(String boardingPoing) {
    this.boardingPoing = boardingPoing;
    return this;
  }

  /**
   * Get boardingPoing
   * @return boardingPoing
  **/
  @ApiModelProperty(value = "")


  public String getBoardingPoing() {
    return boardingPoing;
  }

  public void setBoardingPoing(String boardingPoing) {
    this.boardingPoing = boardingPoing;
  }

  public Bus time(String time) {
    this.time = time;
    return this;
  }

  /**
   * Get time
   * @return time
  **/
  @ApiModelProperty(value = "")


  public String getTime() {
    return time;
  }

  public void setTime(String time) {
    this.time = time;
  }

  public Bus numberofSeatAreFree(Integer numberofSeatAreFree) {
    this.numberofSeatAreFree = numberofSeatAreFree;
    return this;
  }

  /**
   * Get numberofSeatAreFree
   * @return numberofSeatAreFree
  **/
  @ApiModelProperty(value = "")


  public Integer getNumberofSeatAreFree() {
    return numberofSeatAreFree;
  }

  public void setNumberofSeatAreFree(Integer numberofSeatAreFree) {
    this.numberofSeatAreFree = numberofSeatAreFree;
  }

  public Bus costPerSeat(Integer costPerSeat) {
    this.costPerSeat = costPerSeat;
    return this;
  }

  /**
   * Get costPerSeat
   * @return costPerSeat
  **/
  @ApiModelProperty(value = "")


  public Integer getCostPerSeat() {
    return costPerSeat;
  }

  public void setCostPerSeat(Integer costPerSeat) {
    this.costPerSeat = costPerSeat;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bus bus = (Bus) o;
    return Objects.equals(this.busNumber, bus.busNumber) &&
        Objects.equals(this.staffName, bus.staffName) &&
        Objects.equals(this.boardingPoing, bus.boardingPoing) &&
        Objects.equals(this.time, bus.time) &&
        Objects.equals(this.numberofSeatAreFree, bus.numberofSeatAreFree) &&
        Objects.equals(this.costPerSeat, bus.costPerSeat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(busNumber, staffName, boardingPoing, time, numberofSeatAreFree, costPerSeat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Bus {\n");
    
    sb.append("    busNumber: ").append(toIndentedString(busNumber)).append("\n");
    sb.append("    staffName: ").append(toIndentedString(staffName)).append("\n");
    sb.append("    boardingPoing: ").append(toIndentedString(boardingPoing)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    numberofSeatAreFree: ").append(toIndentedString(numberofSeatAreFree)).append("\n");
    sb.append("    costPerSeat: ").append(toIndentedString(costPerSeat)).append("\n");
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

