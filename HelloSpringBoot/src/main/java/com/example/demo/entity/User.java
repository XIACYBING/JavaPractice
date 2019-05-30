package com.example.demo.entity;

import javax.persistence.*;

/**
*@Description 
*@author wang.yubin
*@date 5/27/2019
*/

@Entity
@Table(name="proticable")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="uid")
  private Long uid;

  @Column(name="name")
  private String name;

  @Column(name="pwd")
  private String pwd;

  public Long getUid() {
    return uid;
  }

  public void setUid(Long uid) {
    this.uid = uid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return "User{" +
                   "uid=" + uid +
                   ", name='" + name + '\'' +
                   ", pwd='" + pwd + '\'' +
                   '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;

    if (uid != null ? !uid.equals(user.uid) : user.uid != null) return false;
    if (name != null ? !name.equals(user.name) : user.name != null) return false;
    return pwd != null ? pwd.equals(user.pwd) : user.pwd == null;

  }

  @Override
  public int hashCode() {
    int result = uid != null ? uid.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
    return result;
  }
}
