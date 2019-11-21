package com.wy.pojo;

        import lombok.Data;

        import javax.persistence.*;


@Table(name = "provinces")
@Data

/**
 * 省名
 */
public class Provinces {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name = "id")
  private long id;
  @Column(name = "provinceid")
  private String provinceid;
  @Column(name = "province")
  private String province;




}
