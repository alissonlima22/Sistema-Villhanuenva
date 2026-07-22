/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Alisson
 */
public class AblVenda {

    private Date data;
    private double total;
    private int idCliente;
    private int idVendedor;
    private int idPedido;

    // Código da venda
    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int codigo) {
        this.idPedido = codigo;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date dataVenda) {
        this.data = dataVenda;
    }

    public double getTotal() {
        return this.total;
    }

    public void setTotal(double valorTotal) {
        this.total = valorTotal;
    }

    public int getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(int cliente) {
        this.idCliente = cliente;
    }

    public int getIdVendedor() {
        return this.idVendedor;
    }

    public void setIdVendedor(int vendedor) {
        this.idVendedor = vendedor;
    }

}