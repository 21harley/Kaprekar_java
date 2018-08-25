/*
PROBLEMA 1  
Desarrolla en Lenguaje java el siguiente problema: 
Constante de Kaprekar El matemático indio Dattaraya Ramchandra
Kaprekar descubrió en 1949 una curiosa característica del
número 6174. 
Hoy, se conoce a dicho número como constante de Kaprekar en honor a él. 
El número es notable por la siguiente propiedad: 
1. Elige un número de cuatro dígitos que tenga 
al menos dos diferentes(es válido colocar el dígito 0 al principio,
por lo que el número 0009 es válido). 
2. Coloca sus dígitos en orden ascendente y en orden descendente
para formar dos nuevos números. Puedes añadir los dígitos 0 que 
necesites al principio.
3. Resta el menor al mayor.
4. Vuelve al paso 2. 
A este proceso se le conoce como la rutina de Kaprekar, y siempre llegará 
al número 6174 en, como mucho, 7 iteraciones. Una vez en él, el proceso no 
avanzará, dado que 7641 − 1467 = 6174. Por ejemplo, el número 3524 alcanzará
la constante de Kaprekar en 3 iteraciones: 
5432 − 2345 = 3087 
8730 − 0378 = 8352  
8532 − 2358 = 6174
Los únicos dígitos de cuatro cifras para los que la rutina de Kaprekar 
no alcanza el número 6174 son los repdigits, es decir aquellos cuyas cuatro
cifras son iguales (como 1111), pues en la primera iteración se alcanzará 
el valor 0 y no podrá salirse de él. Es por esto que en el paso 1 se pedía 
explícitamente que el número inicial tuviera al menos dos dígitos diferentes.
El resto de los números de cuatro cifras terminarán siempre en el número 6174.
A continuación se muestran dos ejemplos más: 
 El número 1121 necesita 5 iteraciones: 
2111 − 1112 = 0999
9990 − 0999 = 8991
9981 − 1899 = 8082
8820 − 0288 = 8532
8532 − 2358 = 6174 
 El número 1893 necesita 7: 
9831 − 1389 = 8442
8442 − 2448 = 5994
9954 − 4599 = 5355
5553 − 3555 = 1998
9981 − 1899 = 8082
8820 − 0288 = 8532
8532 − 2358 = 6174 
Entrada Se le pedirá al usuario un número de 4 cifras.
El usuario podrá repetir la operación tantas veces lo 
desee,sin salir del programa.  
Salida Para cada caso de prueba, el programa indicará el
número de vueltas que se debe dar a la rutina de Kaprekar
para alcanzar el 6174. Para los números repdigits deberá
escribir “Numero repdigits”. Para la propia constante de Kaprekar
deberá indicar ”Kaprekar”. 
 */
package kaprekar;
import java.util.*;
import java.io.*;
import java.*;
/**
 *
 * @author John_Llanes
 */
public class Kaprekar {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner lector=new Scanner(System.in);
        DataInputStream lec=new DataInputStream(System.in);
        int resp=0,a=0,kapre,va1=0,va2=0,
            va3=0,va4=0,aux=0,cot=0,ct=0,t=0,inter=1,nume=0;
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
                     System.out.println("Ingrese el numero de 4 digitos y "
                          + "que el numero almenos tenga 2 digitos diferentes");
                     kapre=Integer.parseInt(lec.readLine());
                     if(kapre>9&&kapre<10000){
                        do{
                             cot=0;
                             do{
                                 lis[cot]=kapre%10;kapre/=10;cot++;
                             }while(cot!=4);
                             
                             if(inter==0){
                              for(int i=0;i<lis.length;i++){
                                 va1=lis[i];cot=0;
                                 for(int j=0;j<lis.length;j++){
                                     if(va1==lis[j]){cot++;}
                                 }
                                  if(cot==3){va4=5;}
                               }    }  
                             if(va4!=5){
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
                                 System.out.println("Numero repdigits");
                                 kapre=6174;
                                }
                        }while(kapre!=6174);
                         System.out.println("Numero de interaciones "+
                                 inter);inter=1;
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
