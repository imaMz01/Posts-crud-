package com.Custom.Annotation.Dto;


import com.Custom.Annotation.Validation.AddGroup;
import com.Custom.Annotation.Validation.UpdateGroup;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {



    @Null(groups = AddGroup.class, message = "Order identifier must be null for add operations")
    @NotNull(groups = UpdateGroup.class, message = "Order identifier must not be null for update operations")
    private String id;
    private String nom;
    private String author;
    private LocalDate publicationDate;
}
