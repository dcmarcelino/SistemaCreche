/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sistemacreche.util;

import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Marcelino
 */
public class CodificadorHex {
    
    
    public String toHex (String texto){

         byte[] bytes2 = texto.getBytes();
        String encode = Hex.encodeHexString(bytes2);
        return encode;
    }
    
    public String toTexto (String code) throws DecoderException, UnsupportedEncodingException{

        byte[] bytes = Hex.decodeHex(code.toCharArray());
        String texto = new String(bytes, "UTF-8");
        return texto;
    }
    
}
