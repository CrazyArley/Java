package cn.wengzi.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author leizige
 * @date 19/11/24 15:46 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode
public class Student {
    private Long id;
    private String name;
    private Integer age;
    private String address;
}
