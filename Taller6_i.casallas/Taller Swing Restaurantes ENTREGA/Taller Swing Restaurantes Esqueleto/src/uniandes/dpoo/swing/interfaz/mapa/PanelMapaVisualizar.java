package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class PanelMapaVisualizar extends JPanel
{
    /**
     * La etiqueta donde se dibuja el mapa y se hacen las señales de los restaurantes
     */
    private JLabel labMapa;

    /**
     * La lista de restaurantes que se están dibujando en el mapa
     */
    private List<Restaurante> restaurantes;

    public PanelMapaVisualizar( )
    {
        this.labMapa = new JLabel( new ImageIcon( "./imagenes/mapa.png" ) );
        labMapa.setBorder( new LineBorder( Color.DARK_GRAY ) );
        add( labMapa, BorderLayout.CENTER );
    }

    @Override
    public void paint( Graphics g )
    {
        super.paint( g );
        Graphics2D g2d = ( Graphics2D )g;

     // TODO completar y hacer que se vean los nombres de todos los restaurantes en el mapa
        
        //No entendpi muy bien este pq como que no era como swing jsdfnjsndf
        //itero sobre la lista de restaurantes y para cada uno pinto de rojito sus coordenadas
        //Escribo el nombre al lado
        //Tuve que configurar un poco los pixeles porque como que todo se veia montado y no sabia que mas hacer, lo siento
        
        //verifico que no sea null la lista x si acaso pq al principio la ventana se pintaba como antes de que hubieran restaurantes xdxd y pues no entendi pero con esto se soluciono
        if (restaurantes != null) {
            for (Restaurante r : restaurantes) {
            
                g2d.setColor(Color.RED);
                g2d.fillOval(r.getX() - 4, r.getY() - 4, 8, 8);
                g2d.setColor(Color.BLACK);
                g2d.drawString(r.getNombre(), r.getX() + 5, r.getY());
            }
        }
    
    }
    
    

    /**
     * Actualiza la lista de restaurantes y llama al método repaint() para que se actualice el mapa
     * @param nuevosRestaurantes
     */
    public void actualizarMapa( List<Restaurante> nuevosRestaurantes )
    {
        if( restaurantes != null )
        {
            this.restaurantes.clear( );
            this.restaurantes.addAll( nuevosRestaurantes );
        }
        else
        {
            this.restaurantes = nuevosRestaurantes;
        }
        repaint( );
    }
}
