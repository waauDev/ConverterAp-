package com.converterapi.modelos;

import com.google.gson.annotations.SerializedName;

public class Cambio {

    @SerializedName("result")
    private String result;

    @SerializedName("base_code")
    private String base_code;

    @SerializedName("target_code")
    private String target_code;

    @SerializedName("conversion_rate")
    private double conversion_rate;

    @SerializedName("conversion_result")
    private double conversion_result;

    public double valorCambio;

    public Cambio(ExchangeRate exchangeRate){
        this.base_code = exchangeRate.base_code();
        this.target_code = exchangeRate.target_code();
        this.conversion_rate = Double.valueOf(exchangeRate.conversion_rate());
        this.conversion_result = Double.valueOf(exchangeRate.conversion_result());
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setTarget_code(String target_code) {
        this.target_code = target_code;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }

    public double getValorCambio() {
        return valorCambio;
    }

    public void setValorCambio(double valorCambio) {
        this.valorCambio = valorCambio;
    }

    private String formatDouble (double value){
        return  String.format("%.2f", value);
    }

    public String getFormattedConversionRate(){
        return  formatDouble(this.conversion_rate);
    }

    public String getFormattedConversionResult (){
        return  formatDouble(this.conversion_result);
    }

    @Override
    public String toString() {
        return "----------------------------------------------------------------------------------------------"+
                "\nEl valor " + valorCambio + " ["+base_code+"] " + " corresponde al valor final de  ===> " +
                getFormattedConversionResult() + " ["+target_code+"]" +
                "\nTasa de Conversion: 1" +"["+base_code+"]  = " +getFormattedConversionRate() + "["+target_code+"] "+
                "\n----------------------------------------------------------------------------------------------\n";

    }
}
