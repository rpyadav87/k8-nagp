package com.nagarro.nagp.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userId",
    "firstName",
    "lastName",
    "email"
})
public class UserDetailDto {

  @JsonProperty("userId")
  private Short userId;
  @JsonProperty("firstName")
  private String firstName;
  @JsonProperty("lastName")
  private String lastName;
  @JsonProperty("email")
  private String email;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  @JsonProperty("userId")
  public Short getUserId() {
    return userId;
  }

  @JsonProperty("userId")
  public void setUserId(Short userId) {
    this.userId = userId;
  }

  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  @JsonProperty("firstName")
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  @JsonProperty("lastName")
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @JsonProperty("email")
  public void setEmail(String email) {
    this.email = email;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(UserDetailDto.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("userId");
    sb.append('=');
    sb.append(((this.userId == null) ? "<null>" : this.userId));
    sb.append(',');
    sb.append("firstName");
    sb.append('=');
    sb.append(((this.firstName == null) ? "<null>" : this.firstName));
    sb.append(',');
    sb.append("lastName");
    sb.append('=');
    sb.append(((this.lastName == null) ? "<null>" : this.lastName));
    sb.append(',');
    sb.append("email");
    sb.append('=');
    sb.append(((this.email == null) ? "<null>" : this.email));
    sb.append(',');
    sb.append("additionalProperties");
    sb.append('=');
    sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.firstName == null) ? 0 : this.firstName.hashCode()));
    result = ((result * 31) + ((this.lastName == null) ? 0 : this.lastName.hashCode()));
    result = ((result * 31) +
        ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
    result = ((result * 31) + ((this.userId == null) ? 0 : this.userId.hashCode()));
    result = ((result * 31) + ((this.email == null) ? 0 : this.email.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof UserDetailDto) == false) {
      return false;
    }
    UserDetailDto rhs = ((UserDetailDto) other);
    return ((((((this.firstName == rhs.firstName) ||
        ((this.firstName != null) && this.firstName.equals(rhs.firstName))) &&
        ((this.lastName == rhs.lastName) ||
            ((this.lastName != null) && this.lastName.equals(rhs.lastName)))) &&
        ((this.additionalProperties == rhs.additionalProperties) ||
            ((this.additionalProperties != null) &&
                this.additionalProperties.equals(rhs.additionalProperties)))) &&
        ((this.userId == rhs.userId) ||
            ((this.userId != null) && this.userId.equals(rhs.userId)))) &&
        ((this.email == rhs.email) || ((this.email != null) && this.email.equals(rhs.email))));
  }
}