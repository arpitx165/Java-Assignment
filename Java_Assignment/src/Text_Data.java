/*         
 * Author  Arpit Koolwal
 *           Y13uc046
 *    This code has three parts 
 *    in first part i'm creating ndocx files which has words except file MYSTWORD contains.
 *    in second part i'm trying to find unqiue words in all then files basically i'm removing copy of same words which contains previous files.
 *    in third part i'm counting frequency of each unique word in all doc files which i've created in first step.
 *     End..!!  

 */
import java.util.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;


public class Text_Data {

	@SuppressWarnings({ "null", "resource", "resource", "resource" })
	public static void main(String args[]) throws IOException
	{
		String str,str1 = "";
		int count=0,x,count1=0;
		BufferedReader br = null,br_1=null,br_2=null;
		FileInputStream fs=null,fs_1=null,fs_2=null;
		FileWriter fout=null;
		BufferedWriter bw=null;
		HashSet<String> hashSet= new HashSet<String>();
		HashSet<String> hashSet_1= new HashSet<String>();
		try {
			
		      fs=new FileInputStream("MYSTWORD.txt");
		   
			  br = new BufferedReader(new InputStreamReader(fs));
			  
			
			try {
				while((str=br.readLine())!=null)
				{
					
					hashSet.add(str);
					
				}
			
			/*part-1 ->  started*/	
				for(int i=1;i<=10;i++)
				{
			//	 System.out.println(hashSet);	
					count=0;
					  fout=new FileWriter("ndocx-"+i+".txt");
					  fs=new FileInputStream("doc-"+i);
					  bw= new BufferedWriter(fout);
					  br = new BufferedReader(new InputStreamReader(fs));
					
					// System.out.println(br1.readLine());
					while((x=br.read())!=-1)
					{
				
						   char p;
						   p=(char)x;
					  if(p<'A'||p>'Z'&&p<'a'||p>'z')
						  {
							
						str1=str1.toLowerCase();
						 
						 
						if(str1!="")
					   {
					   	if(!(hashSet.contains(str1)))
							{
								count++;
								bw.flush();
							//	System.out.println(str1); 
								bw.write(str1);
								hashSet_1.add(str1);
								bw.newLine();
							   
							}
					   }
							
							str1="";
							
						  }
					  
				       
					  else
						   {  
							
							str1=str1+(char)x;
							
					       }
					}	
						
			
			   }
			/*part-1 ended*/
				/*part-2 started*/
				 fout=new FileWriter("ndocx-11_unique.txt");
				 bw= new BufferedWriter(fout);
				Iterator <String> it_1=hashSet_1.iterator();
				while(it_1.hasNext())
				{
					count1++;
					bw.flush();
					bw.write(it_1.next());
					bw.newLine();
				}
				/*part-2 ended*/
		        //System.out.println(count);
				str="";
				str1="";
				/*part-3 started*/
				 fout=new FileWriter("ndocx_freq_matrix.txt");
				 bw= new BufferedWriter(fout);
				 
			     
				for(int i=1;i<=10;i++)
				{
					List <String> l1=new ArrayList <String> ();
					fs=new FileInputStream("ndocx-11_unique.txt");
					 br = new BufferedReader(new InputStreamReader(fs));
					 fs_1=new FileInputStream("ndocx-"+i+".txt");
					 br_1=new BufferedReader(new InputStreamReader(fs_1));
					 while((str=br_1.readLine())!=null)
					 {
						 l1.add(str);
					 }
					 if(i==1)
						{
						 fs_2=new FileInputStream("ndocx-11_unique.txt");
						 br_2= new BufferedReader(new InputStreamReader(fs_2));
							bw.flush();
							bw.write("words:-> ");
						 while((str1=br_2.readLine())!=null)
						 {
							
							 bw.flush();
							bw.write(str1+" ");
							 
						 }
						 
						}
					   bw.newLine();
					   bw.newLine();
					   bw.flush();
                       bw.write("doc:"+i+"-> ");
                       
					 while((str1=br.readLine())!=null)
					 {
						 bw.flush();
					     count1=Collections.frequency(l1, str1);	
					     bw.write(count1+" ");
					     
					     
					 }
					 
					 bw.newLine();
					 
					 
				}
				/*part-3 ended*/
				
			}
			
			
			  catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				bw.close();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			br.close();
		}
		
		System.out.println("Process Completed....!!");
		
		
		
	}
}
