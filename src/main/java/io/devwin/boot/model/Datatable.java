package io.devwin.boot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Datatable {

    private int draw;
    private String columns[][];
    private String order[][];
    private int start;
    private int length;
    private String search[][];

}
