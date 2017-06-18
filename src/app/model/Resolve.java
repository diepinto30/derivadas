/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import javax.swing.JOptionPane;
/**
 *
 * @author jonatan omar
 */
public class Resolve 
{
    public String derivar(String function)
    {
        String derivada = "";
        DJep derivar = new DJep();
        derivar.addStandardFunctions();
        derivar.addStandardConstants();
        derivar.addComplex();
        derivar.setAllowUndeclared(true);
        derivar.setAllowAssignment(true);
        derivar.setImplicitMul(true);
        derivar.addStandardDiffRules();
        
        
        
        try
        {
            Node node = derivar.parse(function);
            Node diff = derivar.differentiate(node, "x");
            Node sim = derivar.simplify(diff);
            derivada = derivar.toString(sim);
        }
        
        catch(ParseException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        
        return derivada;
    }
}
