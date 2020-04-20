package com.MVZM.x00216219;
public class PlazaFija extends Empleado
{
  private int extension;

  public PlazaFija(String pNombre , String pPuesto , double pSalario , int pExtension)
  {
    super(pNombre , pPuesto , pSalario);
    extension = pExtension;
  }

  public void setExtension(int sExtension)
  {
    extension = sExtension;
  }

  public int getExtension()
  {
    return extension;
  }
}
