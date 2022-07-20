package com.nace.Helper;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NACEDetailsNotFound extends Exception{
    private String message;

}
