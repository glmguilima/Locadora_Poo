package Exceptions;

import java.io.Serializable;

/**
 * @author glmgu on 25/11/2022
 */
public class MinhaExcecoes extends Exception{
    private static final long serialVersionUID = 1L;

    public MinhaExcecoes(String msg){
        super(msg);
    }   

}
