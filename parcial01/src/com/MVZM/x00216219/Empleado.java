package com.MVZM.x00216219;
public abstract class Empleado
{
  protected String nombre;
  protected String puesto;
  protected double salario;

  public Empleado(String pNombre , String pPuseto , double pSalario)
  {
    nombre = pNombre;
    puesto = pPuseto;
    salario = pSalario;
  }

  public String getNombre()
  {
    return nombre;
  }
  public String getPuesto()
  {
    return puesto;
  }
  public double getSalario()
  {
    return salario;
  }

  public void setSalario(double sSalario)
  {
    salario = sSalario;
  }
}
