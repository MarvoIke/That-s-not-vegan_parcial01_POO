package com.MVZM.x00216219;
import static java.lang.Math.floor;
import static java.lang.Math.round;

public final class CalculadoraImpuestos
{
  private static double totalRenta = 0;
  private static double totalISSS = 0;
  private static double totalAFP = 0;

  private CalculadoraImpuestos() {}

  public static double calcularPago(Empleado unEmpleado)
  {
    double pEntera , pDecimal;
    if(unEmpleado instanceof ServicioProfesional)
    {
      double renta = unEmpleado.getSalario() * 0.1;
      pDecimal = renta;
      pEntera = floor(renta);
      pDecimal = (pDecimal - pEntera) * 100;
      pDecimal = round(pDecimal);
      pDecimal = pDecimal / 100 + pEntera;
      renta = pDecimal;
      totalRenta += renta;
      return unEmpleado.getSalario() - renta;
    }
    else
    {
      double ISSS = unEmpleado.getSalario() * 0.03;
      pDecimal = ISSS;
      pEntera = floor(ISSS);
      pDecimal = (pDecimal - pEntera) * 100;
      pDecimal = round(pDecimal);
      pDecimal = pDecimal / 100 + pEntera;
      ISSS = pDecimal;
      totalISSS += ISSS;

      double afp = unEmpleado.getSalario() * 0.0625;
      pDecimal = afp;
      pEntera = floor(afp);
      pDecimal = (pDecimal - pEntera) * 100;
      pDecimal = round(pDecimal);
      pDecimal = pDecimal / 100 + pEntera;
      afp = pDecimal;
      totalAFP += afp;

      double restante = unEmpleado.getSalario() - ISSS - afp;
      pDecimal = restante;
      pEntera = floor(restante);
      pDecimal = (pDecimal - pEntera) * 100;
      pDecimal = round(pDecimal);
      pDecimal = pDecimal / 100 + pEntera;
      restante = pDecimal;

      double renta = 0;
      if(0.01 <= restante && restante <= 472.00)
        renta = 0.00;
      else if(472.01 <= restante && restante <= 895.24)
        renta = (0.1 * (restante - 472)) + 17.67;
      else if(895.25 <= restante && restante <= 2038.10)
        renta = (0.2 * (restante - 895)) + 60;
      else if(2038.11 <= restante)
        renta = (0.03 * (restante - 2038.10)) + 288.57;

      pDecimal = renta;
      pEntera = floor(renta);
      pDecimal = (pDecimal - pEntera) * 100;
      pDecimal = round(pDecimal);
      pDecimal = pDecimal / 100 + pEntera;
      renta = pDecimal;
      totalRenta += renta;

      return restante - renta;
    }
  }

  public static String mostrarTotales()
  {
    return "Recolectado:\nRenta: " + totalRenta + "$"
             + "\nISSS: " + totalISSS + "$"
             + "\nAFP: " + totalAFP + "$";
  }
}
