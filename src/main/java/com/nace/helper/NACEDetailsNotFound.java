package com.nace.helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NACEDetailsNotFound extends Exception{
    private String message;

}
