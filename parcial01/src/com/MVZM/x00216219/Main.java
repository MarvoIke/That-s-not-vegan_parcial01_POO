package com.MVZM.x00216219;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        String name = null;
        String pos = null;
        double salar = 0;
        int mOe = 0;

        JOptionPane.showMessageDialog(null , "Bienvenid@\nAcontinuacion ingresara la " +
                                               "informacion de dos empleados, al final se le mostraran\nlos salarios" +
                                               " netos y el total de impuestos descontados de ambos empleados.");

        name = JOptionPane.showInputDialog(null , "Ingrese un nombre: ");
        if(name == null)
        {
            JOptionPane.showMessageDialog(null , "Usted cancelo el programa" , "CANCEL"
              , JOptionPane.WARNING_MESSAGE);
            fin();
            return;
        }
        pos = JOptionPane.showInputDialog(null , "Cual es el puesto de " + name + ": ");
        if(pos == null)
        {
            JOptionPane.showMessageDialog(null , "Usted cancelo el programa" , "CANCEL"
              , JOptionPane.WARNING_MESSAGE);
            fin();
            return;
        }

        try
        {
            salar = Double.parseDouble(JOptionPane.showInputDialog(null , "Salario de " + name + ":"));
            if(salar < 0)
                throw new NumberFormatException();

            mOe = Integer.parseInt(JOptionPane.showInputDialog(null , "Meses en contrato:"));
            if(mOe < 0)
                throw new NumberFormatException();
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null , "Usted cancelo el programa" , "CANCEL"
              , JOptionPane.WARNING_MESSAGE);
            fin();
            return;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null , "Entrada invalida" , "ERROR"
              , JOptionPane.ERROR_MESSAGE);
            fin();
            return;
        }
        ServicioProfesional empleadoUno = new ServicioProfesional(name , pos , salar , mOe);
        JOptionPane.showMessageDialog(null , "Empleado #1 (servicio profesional) ingresado correctamente");

        name = JOptionPane.showInputDialog(null , "Ingrese un nombre: ");
        if(name == null)
        {
            JOptionPane.showMessageDialog(null , "Usted cancelo el programa" , "CANCEL"
              , JOptionPane.WARNING_MESSAGE);
            fin();
            return;
        }
        pos = JOptionPane.showInputDialog(null , "Cual es el puesto de " + name + ": ");
        if(pos == null)
        {
            JOptionPane.showMessageDialog(null , "Usted cancelo el programa" , "CANCEL"
              , JOptionPane.WARNING_MESSAGE);
            fin();
            return;
        }

        try
        {
            salar = Double.parseDouble(JOptionPane.showInputDialog(null , "Salario de " + name + ":"));
            if(salar < 0)
                throw new NumberFormatException();
            mOe = Integer.parseInt(JOptionPane.showInputDialog(null , "Extension telefonica:"));
            if(mOe < 0)
                throw new NumberFormatException();
        }
        catch(NullPointerException e)
        {
            JOptionPane.showMessageDialog(null , "Usted cancelo el programa" , "CANCEL"
              , JOptionPane.WARNING_MESSAGE);
            fin();
            return;
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null , "Entrada invalida" , "ERROR"
              , JOptionPane.ERROR_MESSAGE);
            fin();
            return;
        }
        PlazaFija empleadoDos = new PlazaFija(name , pos , salar , mOe);
        JOptionPane.showMessageDialog(null , "Empleado #2 (plaza fija) ingresado correctamente");

        double sn1 = CalculadoraImpuestos.calcularPago(empleadoUno);
        double sn2 = CalculadoraImpuestos.calcularPago(empleadoDos);
        String total = CalculadoraImpuestos.mostrarTotales();

        JOptionPane.showMessageDialog(null , "Salario neto " + empleadoUno.getNombre() + ": " + sn1);
        JOptionPane.showMessageDialog(null , "Salario neto " + empleadoDos.getNombre() + ": " + sn2);

        JOptionPane.showMessageDialog(null , total);
        fin();
    }

    public static void fin()
    {
        JOptionPane.showMessageDialog(null , "Programa finalizado.");
    }
}
