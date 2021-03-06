/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Icon;
import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.border.Border;


public class MenuItem extends javax.swing.JPanel {

    /**
     * @return the subMenu
     */
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }
    
    /**
     * Creates new form MenuItem
     */
    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    
    private ActionListener act;
    public MenuItem(Icon icon, String menuName,ActionListener a,MenuItem... subMenuItem ) {
        initComponents();
        this.setSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
        if(a!=null){
            this.act=a;
        }
        Label_Icon.setIcon(icon);
        Label_Name.setText(menuName);
        for(int i=0;i<subMenuItem.length;i++){
            this.subMenu.add(subMenuItem[i]);
            subMenuItem[i].setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Label_Icon = new javax.swing.JLabel();
        Label_Name = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(54, 70, 70));
        setPreferredSize(new java.awt.Dimension(210, 50));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        Label_Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Label_Icon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Label_Name.setBackground(new java.awt.Color(54, 70, 70));
        Label_Name.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Label_Name.setForeground(new java.awt.Color(255, 255, 255));
        Label_Name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Label_Name.setText("Name");
        Label_Name.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Label_Icon, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_Name, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(Label_Icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing=false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        if(showing){
            hideMenu();
            showing = false;
        }else{
            
            showMenu();
            showing=true;
        }
        if(act!=null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBackground(Color.GRAY);
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setBackground(new Color(54,70,70));
    }//GEN-LAST:event_formMouseExited

    private void showMenu(){
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i=0;i<subMenu.size();i++){
                    sleep();
                    subMenu.get(i).setVisible(true);
                }   
            }           
        });
        t.start();
    }
    private void hideMenu(){
        Thread t = new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i=subMenu.size()-1;i>=0;i--){
                    sleep();
                    subMenu.get(i).setVisible(false);
                }   
            }           
        });
        t.start();
}

    private void sleep() {
             try 
             {
                    Thread.sleep(30);
             } 
             catch (Exception e) {}
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label_Icon;
    private javax.swing.JLabel Label_Name;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}
