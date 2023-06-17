package com.nagarro.nagp.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "users"
})

public class UserResponseDto {

  @JsonProperty("users")
  private List<UserDetailDto> users;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  @JsonProperty("users")
  public List<UserDetailDto> getUsers() {
    return users;
  }

  @JsonProperty("users")
  public void setUsers(List<UserDetailDto> users) {
    this.users = users;
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
    sb.append(UserResponseDto.class.getName()).append('@')
        .append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("users");
    sb.append('=');
    sb.append(((this.users == null) ? "<null>" : this.users));
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
    result = ((result * 31) + ((this.users == null) ? 0 : this.users.hashCode()));
    result = ((result * 31) +
        ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if ((other instanceof UserResponseDto) == false) {
      return false;
    }
    UserResponseDto rhs = ((UserResponseDto) other);
    return (((this.users == rhs.users) || ((this.users != null) && this.users.equals(rhs.users))) &&
        ((this.additionalProperties == rhs.additionalProperties) ||
            ((this.additionalProperties != null) &&
                this.additionalProperties.equals(rhs.additionalProperties))));
  }

}
