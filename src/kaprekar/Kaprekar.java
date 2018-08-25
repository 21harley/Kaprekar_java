/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaprekar;
import java.util.*;
import java.io.*;
import java.*;
/**
 *
 * @author CASA
 */
public class Kaprekar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lector=new Scanner(System.in);
        DataInputStream lec=new DataInputStream(System.in);
        int resp=0,a=0,kapre,va1=0,va2=0,
            va3=0,aux=0,cot=0,ct=0,t=0,inter=1,nume=0;
        int []lis =new int[4];
        do{
           try{
             if(resp==1 || resp==0){
             System.out.println("*-----Bienvenidos a caculadora Airus-----*");
             System.out.println("*----- 1)Calcular Kaprekar --------------*");
             System.out.println("*----- 2)salir --------------------------*");
             resp=Integer.parseInt(lec.readLine());
             switch(resp){
                 case 1:
                     System.out.println("Ingrese el numero de 4 digitos y"
                          + "que el numero almos tenga 2 digitos diferentes");
                     kapre=Integer.parseInt(lec.readLine());
                     if(kapre>9&&kapre<10000){
                         do{
                             cot=0;
                             do{
                                 lis[cot]=kapre%10;kapre/=10;cot++;
                             }while(cot!=4);
                                                         
                             for(int i=0;i<lis.length;i++){
                                 va1=lis[i];cot=0;
                                 for(int j=0;j<lis.length;j++){
                                     if(va1==lis[j]){cot++;}
                                 }
                                 if(cot==4){
                                     va1=5;
                                 }
                             } 
                             if(va1!=5){
                                do{
                              cot=0;
                             for(int i=0;i<lis.length;i++){
                                    if(i+1!=lis.length){
                                        if(lis[i+1]>lis[i]){
                                           aux=lis[i];
                                           lis[i]=lis[i+1];
                                           lis[i+1]=aux;cot++;
                                        }
                              } }aux=0;
                                    }while(cot!=0);
                                t=1000;va1=0;
                             for(int i=0;i<lis.length;i++){
                                  System.out.println("Valor "+(i+1)+" "+lis[i]);
                                  va1+=lis[i]*t;
                                  t/=10;if(t==0){t=1;} }
                              
                             for (int i=0; i<lis.length/2; i++){
                                     aux = lis[i];
                                     lis[i] = lis[lis.length-1-i];
                                     lis[lis.length-1-i] = aux;}
                                                       
                             t=1000;va2=0;
                             for(int i=0;i<lis.length;i++){
                               System.out.println("Valor "+(i+1)+" "+lis[i]);
                                va2+=lis[i]*t;
                               t/=10;if(t==0){t=1;} }
                             kapre=va1-va2;
                                 System.out.println("V1: "+va1);
                                 System.out.println("V2: "+va2);
                                 System.out.println("Kapreka: "+kapre);
                             va1=0;va2=0;
                              if(kapre!=6174){
                                  inter++;
                              }
                               }else{
                                 System.out.println("El valor no cumple "
                                         + "el tener 2 numeros diferente");
                                 kapre=6174;
                                }
                         }while(kapre!=6174);
                         System.out.println("Numero de interaciones "+
                                 inter);inter=0;
                     }else{
                         System.out.println("Valor invalido vuelva a intentar");
                     }
                 break;
                 case 2:
                     a++;
                 break;
             }   
            }else{
                 System.out.println("Valor no permitido vuelva a ingresar el "
                         + "valor");resp=0;
            }   
           }catch(NumberFormatException ex){
                System.out.println("los datos son invalidos vuelva a ingresar "
                        + "los datos");
           }
        }while(a==0);
      
        
    }
    
}
