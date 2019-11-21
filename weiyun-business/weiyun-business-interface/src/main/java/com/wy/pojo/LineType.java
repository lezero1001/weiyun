package com.wy.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 路程类型
 */
@Table(name = "line_type")
@Data
public class LineType {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "line_type")
  private String lineType;




}
