package com.MVZM.x00216219;
public class ServicioProfesional extends Empleado
{
  private int mesesContrato;

  public ServicioProfesional(String pNombre , String pPuesto , double pSalario , int pMesesContrato)
  {
    super(pNombre , pPuesto , pSalario);
    mesesContrato = pMesesContrato;
  }

  public void setMeses(int sMeses)
  {
    mesesContrato = sMeses;
  }
  public int getMeses()
  {
    return mesesContrato;
  }
}
