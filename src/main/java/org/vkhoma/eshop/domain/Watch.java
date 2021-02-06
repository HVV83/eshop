package org.vkhoma.eshop.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "watches")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString(of = {"id", "title", "price", "description"})
public class Watch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Title is required")
    private String title;

    @Min(value = 0, message = "A price should be positive")
    private Integer price;

    @NotEmpty(message = "Description is required")
    private String description;

    @Pattern(regexp = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$", message = "Image Base64 expected")
    private String fountain;

}
