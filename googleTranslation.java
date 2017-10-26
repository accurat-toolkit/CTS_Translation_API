import com.google.api.GoogleAPI;
import com.google.api.translate.Language;
import com.google.api.translate.Translate;
import org.json.JSONException;
import java.io.*;
import java.util.*;
public class googleTranslation {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
          //    googleTranslation a=new googleTranslation();
            /*  Translate.setHttpReferrer("localhost");
      			Language[] lang=Language.values();
      		    for (int i=0;i<lang.length;i++){
      			System.out.print(lang[i].name()+" ");
      		    } */ 
           
             /*   if (args.length!=5){
                	System.out.println("Usage: java -jar Translation.jar option SourceLanguage TargetLanguage SourcePath TargetPath");
                	System.out.println("option: tranlsation by string array (option=1) or not (option=2)");
                	System.out.println("SourePath: The path to the text collection to be translated");
                	System.out.println("TargetPath: The path to the translated text collection");
                	System.out.println("Example (linux): java -jar BingTranslate.jar option=1 LATVIAN ENGLISH "+"/home/fzsu/sample/LV "+"/home/fzsu/LV-translation");
                	System.out.println("Example (windows): java -jar BingTranslate.jar option=1 LATVIAN ENGLISH "+"C:\\sample\\LV "+"C:\\LV-translation");
                } else{
                	if (args[0].equals("option=1")){
                	//	  a.ArrayTranslation("LATVIAN", "ENGLISH", "/home/fzsu/tilde-LV-EN/ITLocalizationLV/TextFiles", "/home/fzsu/test-translation");
                		 a.ArrayTranslation(args[1], args[2], args[3], args[4]);
                	}
                	if (args[0].equals("option=2")){
                	//	 a.translation("LATVIAN", "ENGLISH", "/home/fzsu/tilde-LV-EN/ITLocalizationLV/TextFiles", "/home/fzsu/test-translation");
                		a.translation(args[1], args[2], args[3], args[4]);
                	}
                }  */
              
         /*     if (args.length<8){
              	System.out.println("Usage: java -jar Translation.jar option -SL sourcelanguage -TL targetlanguage [-Array] -SP sourcepath|-SF sourcefile -TP targetpath");
              	System.out.println("-SL sourcelanguage: the language to be translated from");
              	System.out.println("-TL sourcelanguage: the language to be translated to");
              	System.out.println("-Array: optional, translating document by string array");
              	System.out.println("-SP sourepath: The path to the text collection to be translated (must exist)");
              	System.out.println("-SF sourefile: The path to the document which lists the documents to be translated (must exist)");
              	System.out.println("-TP targetpath: The path to the directory which will store the tranlsated documents (must exist)");
              	System.out.println("Example (linux): java -jar BingTranslate.jar -SL LATVIAN -TL ENGLISH "+"-SP /home/fzsu/sample/LV "+"-TP /home/fzsu/LV-translation");
              	System.out.println("Example (windows): java -jar BingTranslate.jar -SL LATVIAN -TL ENGLISH "+"-SP C:\\sample\\LV "+"-TP C:\\sample\\LV-translation");
              }else{
              	String SL="";
              	String TL="";
              	boolean array=false;
              	String SP="";
              	String SF="";
              	String TP="";
              	for (int i=0;i<args.length;i++){
              		if (args[i].toLowerCase().equals("-sl")&&i<args.length-1){
              			SL=args[i+1].toUpperCase();
              		}
              		if (args[i].toLowerCase().equals("-tl")&&i<args.length-1){
              			TL=args[i+1].toUpperCase();
              		}
              		if (args[i].toLowerCase().equals("-sp")&&i<args.length-1){
              			SP=args[i+1];
              		}
              		if (args[i].toLowerCase().equals("-tp")&&i<args.length-1){
              			TP=args[i+1];
              		}
              		if (args[i].toLowerCase().equals("-sf")&&i<args.length-1){
              			SF=args[i+1];
              		}
              		if (args[i].toLowerCase().equals("-array")){
              			array=true;
              		}
              		}
              		if (array==false &&SP.length()>0){
              			a.translations(SL,TL,SP,TP);
              		}
              		if (array==false &&SF.length()>0){
              			a.translationList(SL,TL,SF,TP);
              		}
              		if (array==true &&SP.length()>0){
              			a.ArrayTranslations(SL,TL,SP,TP);
              		}
              		if (array==true &&SF.length()>0){
              			a.ArrayTranslationList(SL,TL,SF,TP);
              		}
              	
              }   */
       
//	}

	public void translation(String source, String target, String sourcepath, String targetpath){
	//	FileWriter fw=null;
	//	PrintWriter pw=null;
		try{
			System.out.println("Start translation...");
		//	GoogleAPI.setKey("ABQIAAAA0I5T8qNIpXZhKcTKysEazBRZcFhyFUVXvu32ve0Wx1LrheqW2xQ84FZAgsTr2j0QrMte8tSEHKorSQ");
			Translate.setHttpReferrer("localhost");
			String s="";
			Language SL=Language.valueOf(source);
			Language TL=Language.valueOf(target);
	/*		File file=new File(targetpath+File.separator+"file.done");
			if (!file.exists()){
				file.createNewFile();
			} 
			BufferedReader br2=new BufferedReader(new FileReader(targetpath+File.separator+"file.done"));
		    ArrayList alist=new ArrayList();
		    while (true){
		    	s=br2.readLine();
		    	if (s==null){
		    		break;
		    	}
		    	else{
		    		alist.add(s);
		    	}
		    } */
		    String savedirectory=targetpath+File.separator+"tranalsation";
		    File dir=new File(savedirectory);
		    dir.mkdir();
		//    fw = new FileWriter(targetpath+File.separator+"file.done",true);  
		//    pw=new PrintWriter(fw); 
		    File f=new File(sourcepath);
			File[] list=f.listFiles();
		    for (int i=0;i<list.length;i++){ 
		//		if (!alist.contains(list[i].getName())){
						System.out.println(list[i].getName());
						String text="";
						boolean flag=false;
					    BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream(list[i].getAbsolutePath()), "UTF8"));
					    BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savedirectory+File.separator+list[i].getName()), "UTF8"));
					    while (true){
					    	s=br1.readLine();
					    	if (s==null){
					    		break;
					    	}else{
					    		if (s.trim().length()>0){
					    			if ((text.length()+s.trim().length())<5000){
					    				text=text+" "+s.trim();
					    			}else{
					    				flag=true;
					    			}
					    		}  
					    		if (flag==true){
					    	//		System.out.println(text);
					    			String result = GetTranslation(text, SL, TL);
					    	//		System.out.println(result);
							    	bw.write(result);
							    	bw.newLine();
							       text=s.trim();
							    	flag=false;
							//     Thread.sleep(1000);
					    		}
					    	}
					    }
					    if (text.length()>0){
					//    System.out.println(text);  
					    String result = GetTranslation(text, SL, TL);
	    			//    System.out.println(result);
			    		 bw.write(result);
			    		 bw.newLine();
					    }
					     bw.flush();
					     bw.close();
					     br1.close();
					  //   pw.println(list[i].getName());				     
				//	}
				}
			System.out.println("Translation is all done");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		/*finally{
			try{
				 pw.close();  
			    fw.close(); 
            }catch(IOException e){
            //    System.out.println("关闭文件流错误！");
                e.printStackTrace();
            }
		} */
	}

	/*
	 * this is the updated version requested by TILDE
	 */
public void translations(String source, String target, String sourcepath, String targetpath){
	try{
		System.out.println("Start translation...");
	//	GoogleAPI.setKey("ABQIAAAA0I5T8qNIpXZhKcTKysEazBRZcFhyFUVXvu32ve0Wx1LrheqW2xQ84FZAgsTr2j0QrMte8tSEHKorSQ");
		Translate.setHttpReferrer("localhost");
		String s="";
		Language SL=Language.valueOf(source);
		Language TL=Language.valueOf(target);
		ArrayList alist=new ArrayList();
		TreeMap<Long,File> tm = new TreeMap<Long,File>();
		File file = new File(targetpath);
		File subFile[] = file.listFiles();
		int fileNum = subFile.length;
	    if (fileNum>0){
	   for (int i = 0; i < fileNum; i++) {
		   Long tempLong = new Long(subFile[i].lastModified());
		   tm.put(tempLong, subFile[i]);
		  }
					//  System.out.println("最近的一个文件的路径-->"+tm.get(tm.lastKey()).getPath());
			tm.get(tm.lastKey()).delete();
			}	
		File ff=new File(targetpath);
		File[] files=ff.listFiles();
		for (int i=0;i<files.length;i++){
			alist.add(files[i].getName());
		}
	//	System.out.println(alist.size());
	   File f=new File(sourcepath);
	   File[] list=f.listFiles();
	   for (int i=0;i<list.length;i++){ 
			if (!alist.contains(list[i].getName())){
				System.out.println(i+": "+list[i].getName());
				String text="";
			    BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream(list[i].getAbsolutePath()), "UTF8"));
		       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetpath+File.separator+list[i].getName()), "UTF8"));
				while (true){
				 s=br1.readLine();
			     if (s==null){
			 		break;
				   	}else{
						s=s.trim();
						if (s.length()>0 ){
						  if (s.length()>=4500){
			                  ArrayList chunk=new ArrayList();
			                  chunks(chunk,s,4000);
			                     for (int j=0;j<chunk.size();j++){
			                    	 String segment=chunk.get(j).toString();
			                    	 if (text.length()+segment.length()<4500){
			                    		 text=text+" "+segment;
			                    	 }else{
			                    	//	 System.out.println(text.length()+" "+text);
							    			String result = GetTranslation(text, SL, TL);
							    	//		System.out.println(result);
									    	bw.write(result);
									    	bw.newLine();
									       text=segment; 	
									//     Thread.sleep(1000);
			                    	 }
			                     }
						    }   
						   else{
						        if ((text.length()+s.length())<4500){
						    				text=text+" "+s;
						    			}else{
						    		//		System.out.println(text.length()+" "+text);
							    			String result = GetTranslation(text, SL, TL);
							    	//		System.out.println(result);
									    	bw.write(result);
									    	bw.newLine();
									       text=s;
									    	
									//     Thread.sleep(1000);
						    			}
						    			}
						    		}  
						    	
						    	}
						    }
						    if (text.length()>0){
						 // System.out.println("REST:"+text.length()+" "+text);
						    String result = GetTranslation(text, SL, TL);
		    			//    System.out.println(result);
				    		 bw.write(result);
				    		 bw.newLine();
						    }
						     bw.flush();
						     bw.close();
						     br1.close();			     
						}
					}
				System.out.println("Translation is all done");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		
		}	


/*
 * this is the updated version requested by TILDE
 */
public void translationList(String source, String target, String sourcepath, String targetpath){
try{
	System.out.println("Start translation...");
//	GoogleAPI.setKey("ABQIAAAA0I5T8qNIpXZhKcTKysEazBRZcFhyFUVXvu32ve0Wx1LrheqW2xQ84FZAgsTr2j0QrMte8tSEHKorSQ");
	Translate.setHttpReferrer("localhost");
	String s="";
	Language SL=Language.valueOf(source);
	Language TL=Language.valueOf(target);
	ArrayList alist=new ArrayList();
	String transpath=targetpath+File.separator+source+"-translation";
	File f5=new File(transpath);
	if (!f5.exists()){
		f5.mkdir();
	}
	TreeMap<Long,File> tm = new TreeMap<Long,File>();
	File file = new File(transpath);
	File subFile[] = file.listFiles();
	int fileNum = subFile.length;
    if (fileNum>0){
   for (int i = 0; i < fileNum; i++) {
	   Long tempLong = new Long(subFile[i].lastModified());
	   tm.put(tempLong, subFile[i]);
	  }
				//  System.out.println("最近的一个文件的路径-->"+tm.get(tm.lastKey()).getPath());
		tm.get(tm.lastKey()).delete();
		}	
	File ff=new File(transpath);
	File[] files=ff.listFiles();
	for (int i=0;i<files.length;i++){
		alist.add(files[i].getName());
	}
//	System.out.println(alist.size());
	BufferedReader br=new BufferedReader(new FileReader(sourcepath));
	int count=0;
	while (true){
		s=br.readLine();
		if (s==null){
			break;
		}else{
			count++;
		//	ff=new File(s);
			String names[]=s.replaceAll("\\\\","/").split("/");	
			String fullname="";
		/*	for (int k=0;k<names.length;k++){
				System.out.println(k+" "+names[k]);
			} */
			if (names[0].contains(":")){
				names[0]=names[0].replace(":", "@@@");
			}
			for (int k=0;k<names.length-1;k++){
				fullname=fullname+names[k]+"###";
			} 
			fullname=fullname+names[names.length-1]; 
			if (!alist.contains(fullname)){
		//	if (!alist.contains(ff.getName())){
			System.out.println(count+": "+s);
			String text="";
			boolean flag=true;
		    BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream(s), "UTF8"));
	        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(transpath+File.separator+fullname), "UTF8"));
			while (true){
			 s=br1.readLine();
		     if (s==null){
		 		break;
			   	}else{
					s=s.trim();
					if (s.length()>0 ){
					  if (s.length()>=4500){
		                  ArrayList chunk=new ArrayList();
		                  chunks(chunk,s,4000);
		                     for (int j=0;j<chunk.size();j++){
		                    	 String segment=chunk.get(j).toString();
		                    	 if (text.length()+segment.length()<4500){
		                    		 text=text+" "+segment;
		                    	 }else{
		                    	//	 System.out.println(text.length()+" "+text);
						    			String result = GetTranslation(text, SL, TL);
						    			if (result==null){
						    				flag=false;
						    			}else{
						    	//		System.out.println(result);
						    			
								    	bw.write(result);
								    	bw.newLine();
						    			}
								        text=segment; 	
								//     Thread.sleep(1000);
		                    	 }
		                     }
					    }   
					   else{
					        if ((text.length()+s.length())<4500){
					    				text=text+" "+s;
					    			}else{
					    		//		System.out.println(text.length()+" "+text);
						    			String result = GetTranslation(text, SL, TL);
						    	//		System.out.println(result);
						    			if (result==null){
						    				flag=false;
						    			}else{
								    	bw.write(result);
								    	bw.newLine();
						    			}
								       text=s;
								    	
								//     Thread.sleep(1000);
					    			}
					    			}
					    		}  
					    	
					    	}
					    }
					    if (text.length()>0){
					 // System.out.println("REST:"+text.length()+" "+text);
					    String result = GetTranslation(text, SL, TL);
	    			//    System.out.println(result);
					    if (result==null){
		    				flag=false;
		    			}else{
			    		 bw.write(result);
			    		 bw.newLine();
		    			}
					    }
					     bw.flush();
					     bw.close();
					     br1.close();
					     if (flag==false){
						    	File wrongFile=new File(transpath+File.separator+fullname);
						        wrongFile.delete();
						    }
					}
				}
	}
	 br.close();
	 ff=new File(transpath);
	 files=ff.listFiles();
	 BufferedWriter bw1=new BufferedWriter(new FileWriter(targetpath+File.separator+source+"-translation.txt"));
	for (int i=0;i<files.length;i++){
		bw1.write(files[i].getAbsolutePath());
		bw1.newLine();
	}
	bw1.flush();
	bw1.close();
	System.out.println("Translation is all done");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	
	}	





	
	public String GetTranslation(String text, Language source, Language target){
		 String result = "";
		 try{
		result= Translate.execute(text, source, target);
		 }catch(Exception ex){
		  //   ex.printStackTrace();
		     boolean condition = true;
		     int j=0;
		     while(condition) {
		       try {
		    	   System.out.println("Encounter translation access limitation, please wait for "+(3*j)+" seconds");
		    	   Thread.sleep(3000*(j+1));
		    		result= Translate.execute(text, source, target);
		          condition = false; //如果没有异常就跳出循环。
		       }
		       catch(Exception e) {
		   //    e.printStackTrace();
		         j++;
		         if (j>7){
		        	 result=null;
		        	 condition=false;
		         }
		       } //有异常就回到原点继续。
		     }
		 }
		 return result;
	}
	
	
	public String[] GetArrayTranslation(String[] text, Language source, Language target){
		 String[] result=null;
		 try{
		result= Translate.execute(text, source, target);
		 }/*catch(org.json.JSONException ex){
			 ex.printStackTrace();
			 System.out.println("YOR ARE CAUGHT");
		 }  */
		 catch(Exception ex){
		//	 System.out.println(ex);
		     ex.printStackTrace();
		     boolean condition = true;
		     int j=0;
		     while(condition) {
		       try {
		    	   System.out.println("Encounter translation access limitation, please wait for "+(3*j)+" seconds");
		    	   int size=0;
		    	   for (int k=0;k<text.length;k++){
		    		   size=size+text[k].length();
		    		   System.out.println(text[k]);
		    	   } 
		    	   System.out.println(size); 
		    	   Thread.sleep(3000*(j+1));
		    		result= Translate.execute(text, source, target);
		          condition = false; //如果没有异常就跳出循环。
		       }
		       catch(Exception e) {
		       e.printStackTrace();
		         j++;
		       } //有异常就回到原点继续。
		     }
		 }  
		 return result;
	}

	
	
	public String[] GetArrayTranslations(String[] text, Language source, Language target){
		 String[] result=null;
		 try{
		result= Translate.execute(text, source, target);
		 }/*catch(org.json.JSONException ex){
			 ex.printStackTrace();
			 System.out.println("YOR ARE CAUGHT");
		 }  */
		 catch(Exception ex){
		//	 System.out.println(ex);
		     ex.printStackTrace();
		     boolean condition = true;
		     int j=0;
		     while(condition) {
		       try {
		    	   System.out.println("Encounter translation access limitation, please wait for "+(3*j)+" seconds");
		    	   int size=0;
		  /*  	   for (int k=0;k<text.length;k++){
		    		   size=size+text[k].length();
		    		   System.out.println(text[k]);
		    	   } 
		    	   System.out.println(size); */
		    	   Thread.sleep(3000*(j+1));
		    		result= Translate.execute(text, source, target);
		          condition = false; //如果没有异常就跳出循环。
		       }
		       catch(Exception e) {
		       e.printStackTrace();
		         j++;
		         if (j>6){
		        	  condition=false;
		        	  result=null;
		          }
		       } //有异常就回到原点继续。
		     }
		 }  
		 return result;
	}
		

	
	public String[] ObtainArrayTrans(String[] text, Language source, Language target){
		 String[] result=null;
		 try{
		result= Translate.execute(text, source, target);
		 }catch(JSONException ex){
			 ex.printStackTrace();
			// System.out.println("YOR ARE CAUGHT");
			 ArrayList alist=new ArrayList();
			 
		 } 
		 catch(Exception ex){
			
			 
		//	 System.out.println("can you catch it?");
		     ex.printStackTrace();
		     boolean condition = true;
		     int j=0;
		     while(condition) {
		       try {
		    	   System.out.println("Encounter translation access limitation, please wait for "+(3*j)+" seconds");
		    	   int size=0;
		    	   for (int k=0;k<text.length;k++){
		    		   size=size+text[k].length();
		    		   System.out.println(text[k]);
		    	   } 
		    	   System.out.println(size); 
		    	   Thread.sleep(3000*(j+1));
		    		result= Translate.execute(text, source, target);
		          condition = false; //如果没有异常就跳出循环。
		       }
		       catch(Exception e) {
		       e.printStackTrace();
		         j++;
		       } //有异常就回到原点继续。
		     }
		 }  
		 return result;
	}	
	
	
	
	
public void ArrayTranslation(String source, String target, String sourcepath, String targetpath){

	try{
		System.out.println("Start translation now...");
		Translate.setHttpReferrer("localhost");
		String s="";
		Language SL=Language.valueOf(source);
		Language TL=Language.valueOf(target);
		ArrayList alist=new ArrayList();
		 TreeMap<Long,File> tm = new TreeMap<Long,File>();
		  File file = new File(targetpath);
		  File subFile[] = file.listFiles();
		  int fileNum = subFile.length;
		  if (fileNum>0){
		  for (int i = 0; i < fileNum; i++) {
		   Long tempLong = new Long(subFile[i].lastModified());
		   tm.put(tempLong, subFile[i]);
		  }
			//  System.out.println("最近的一个文件的路径-->"+tm.get(tm.lastKey()).getPath());
		  tm.get(tm.lastKey()).delete();
		  }	
		File ff=new File(targetpath);
		File[] files=ff.listFiles();
		for (int i=0;i<files.length;i++){
			alist.add(files[i].getName());
		}
		System.out.println(alist.size());
	//	String savedirectory=targetpath+File.separator+"tranalsation";
	//	File dir=new File(savedirectory);
	//	dir.mkdir();

		File f=new File(sourcepath);
		File[] list=f.listFiles();  
		for (int i=0;i<list.length;i++){ 
		if (!alist.contains(list[i].getName())){
			System.out.println(list[i].getName());
			boolean flag=false;
			BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream(list[i].getAbsolutePath()), "UTF8"));
		   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetpath+File.separator+list[i].getName()), "UTF8"));
		   ArrayList lines=new ArrayList();
		   int lineLength=0;
			while (true){
			s=br1.readLine();
			if (s==null){
			   break;
			}else{
				if (s.trim().length()>0){
					  if ((lineLength+s.trim().length())<2000){
					    	lines.add(s.trim());
					    	lineLength=lineLength+s.trim().length();
					    	}else{
					    		//System.out.println(lineLength);
					    		flag=true;
					    		}
					    	}  
					    if (flag==true){
					    	for (int k=0;k<lines.size();k++){
					   // 		System.out.println(lines.get(k).toString());
					    		} 
					    		int size=lines.size();
					    		String[] array = (String[])lines.toArray(new String[size]);
					    		String[] result = GetArrayTranslation(array, SL, TL);
					    //		String[] result = ObtainArrayTrans(array, SL, TL);
					    		for (int k=0;k<result.length;k++){
					    		//	System.out.println(result[k]);
							    	bw.write(result[k]);
							    	bw.newLine();
					    			}
					    		lines.clear();
							    lines.add(s.trim());
							    lineLength=s.trim().length(); 
							    flag=false;
							//     Thread.sleep(1000);
					    		}
					    	}
					    }
			if (lineLength>0){
			   for (int k=0;k<lines.size();k++){
			//      System.out.println(lines.get(k).toString());
			    	} 
				int size=lines.size();
			    String[] array = (String[])lines.toArray(new String[size]);
			   	String[] result = GetArrayTranslation(array, SL, TL);
		//	    String[] result = ObtainArrayTrans(array, SL, TL);
			    for (int k=0;k<result.length;k++){
			//    	System.out.println(result[k]);
					bw.write(result[k]);
					bw.newLine();
			    			}
					    }
			bw.flush();
			bw.close();
		   br1.close();
		//	pw.println(list[i].getName());				     
			}
				}
			System.out.println("Translation is all done!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}


/*
 * ARRAYTranslations, requested by TILDE
 */

public void ArrayTranslations(String source, String target, String sourcepath, String targetpath){

	try{
		System.out.println("Start translation now...");
		Translate.setHttpReferrer("localhost");
		String s="";
		Language SL=Language.valueOf(source);
		Language TL=Language.valueOf(target);
		ArrayList alist=new ArrayList();
		 TreeMap<Long,File> tm = new TreeMap<Long,File>();
		  File file = new File(targetpath);
		  File subFile[] = file.listFiles();
		  int fileNum = subFile.length;
		  if (fileNum>0){
		  for (int i = 0; i < fileNum; i++) {
		   Long tempLong = new Long(subFile[i].lastModified());
		   tm.put(tempLong, subFile[i]);
		  }
			//  System.out.println("最近的一个文件的路径-->"+tm.get(tm.lastKey()).getPath());
		  tm.get(tm.lastKey()).delete();
		  }	
		File ff=new File(targetpath);
		File[] files=ff.listFiles();
		for (int i=0;i<files.length;i++){
			alist.add(files[i].getName());
		}
		System.out.println(alist.size());
		File f=new File(sourcepath);
		File[] list=f.listFiles();  
		for (int i=0;i<list.length;i++){ 
		if (!alist.contains(list[i].getName())){
			System.out.println(list[i].getName());
			boolean flag=false;
			BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream(list[i].getAbsolutePath()), "UTF8"));
		   BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetpath+File.separator+list[i].getName()), "UTF8"));
		   ArrayList lines=new ArrayList();
		   int lineLength=0;
			while (true){
			s=br1.readLine();
			if (s==null){
			   break;
			}else{
				s=s.trim();
				 if (s.length()>0){
				  if (s.length()>=3000){
					if (lines.size()>0){
					/*	System.out.println("TYPE 1::::"+lineLength);
						
						for (int k=0;k<lines.size();k++){
							System.out.println(lines.get(k).toString());
						} */
						int size=lines.size();
					    String[] array = (String[])lines.toArray(new String[size]);
					   	String[] result = GetArrayTranslations(array, SL, TL);
				//	    String[] result = ObtainArrayTrans(array, SL, TL);
				//	   	Thread.sleep(500);
					   	 if (result==null){
					   		 flag=true;
					   	 }else{
					   	for (int k=0;k<result.length;k++){
					//    	System.out.println(result[k]);
							bw.write(result[k]);
							bw.newLine();
					    			}
					   	 }
					lines.clear();
					lineLength=0;
					} 
					ArrayList chunk=new ArrayList();
					chunks(chunk,s,2000);
					String res="";
					String candidate="";
					for (int j=0;j<chunk.size();j++){
						String segment=chunk.get(j).toString();
						if ((lineLength+segment.length())<3000){
							lines.add(segment);
							lineLength=lineLength+segment.length();
						}else{
							int size=lines.size();
						/*	System.out.println("TYPE 2::::"+lineLength);
							for (int k=0;k<lines.size();k++){
							//	System.out.println(lines.get(k).toString());
								candidate=candidate+lines.get(k).toString()+" ";
							} */
				    		String[] array = (String[])lines.toArray(new String[size]);
				    		String[] result = GetArrayTranslations(array, SL, TL);
				    		//Thread.sleep(500);
				    		if (result==null){
				    			flag=true;	
				    		}else{
				    		for (int k=0;k<result.length;k++){
				    			res=res+result[k]+" ";
				    		} 
				    		}
				    		lines.clear();
				    		lines.add(segment);
				    		lineLength=segment.length();
						}
					}
					if (lines.size()>0){
				/*		System.out.println("TYPE 3::::"+lineLength);
						
						for (int k=0;k<lines.size();k++){
						//	System.out.println(lines.get(k).toString());
							candidate=candidate+lines.get(k).toString()+" ";
						} */
						int size=lines.size();
			    		String[] array = (String[])lines.toArray(new String[size]);
			    		String[] result = GetArrayTranslations(array, SL, TL);
			    	//	Thread.sleep(500);
			    		if (result==null){
			    			flag=true;
			    			
			    		}else{
			    		for (int k=0;k<result.length;k++){
			    			res=res+result[k]+" ";
			    		} 
			    		}
			    //		System.out.println(candidate);
			    		bw.write(res);
			    		bw.newLine();
			    		lines.clear();
			    		lineLength=0;
					}		
				}
				else{
					  if ((lineLength+s.length())<3000){
					    	lines.add(s);
					    	lineLength=lineLength+s.length();
					    	}else{
					    		//System.out.println(lineLength);
					   	/*	System.out.println("TYPE 4::::"+lineLength);
					    	  	for (int k=0;k<lines.size();k++){
									    		System.out.println(lines.get(k).toString());
									 }  */
									int size=lines.size();
									String[] array = (String[])lines.toArray(new String[size]);
									String[] result = GetArrayTranslations(array, SL, TL);
									    //		String[] result = ObtainArrayTrans(array, SL, TL);
								//	Thread.sleep(500);
									if (result==null){
						    			flag=true;
						    			
						    		}else{
									for (int k=0;k<result.length;k++){
							   //	System.out.println(result[k]);
									bw.write(result[k]);
								 	bw.newLine();
									   	} 
						    		}
									 lines.clear();
									 lines.add(s);
									 lineLength=s.length();	
											//     Thread.sleep(1000);
					    		}
					    	}  
				 }
					}
					    }
			if (lineLength>0){
				/*	System.out.println("TYPE 5::::"+lineLength);
			   for (int k=0;k<lines.size();k++){
			     System.out.println(lines.get(k).toString());
			    	}  */
				int size=lines.size();
			    String[] array = (String[])lines.toArray(new String[size]);
			   	String[] result = GetArrayTranslations(array, SL, TL);
		//	    String[] result = ObtainArrayTrans(array, SL, TL);
			   	if (result==null){
	    			flag=true;
	    			
	    		}else{
			   	for (int k=0;k<result.length;k++){
			//    	System.out.println(result[k]);
					bw.write(result[k]);
					bw.newLine();
			    			} 
			}
					    }
			bw.flush();
			bw.close();
		   br1.close();
		   Thread.sleep(500);
		    if (flag==true){
		    	File wrongFile=new File(targetpath+File.separator+list[i].getName());
		        wrongFile.delete();
		    }
			}
				}
			System.out.println("Translation is all done!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}



/*
 * ARRAYTranslations, requested by TILDE
 */

public void ArrayTranslationList(String source, String target, String sourcepath, String targetpath){

	try{
		System.out.println("Start translation now...");
		Translate.setHttpReferrer("localhost");
		String s="";
		Language SL=Language.valueOf(source);
		Language TL=Language.valueOf(target);
		ArrayList alist=new ArrayList();
		 TreeMap<Long,File> tm = new TreeMap<Long,File>();
		  File file = new File(targetpath);
		  File subFile[] = file.listFiles();
		  int fileNum = subFile.length;
		  if (fileNum>0){
		  for (int i = 0; i < fileNum; i++) {
		   Long tempLong = new Long(subFile[i].lastModified());
		   tm.put(tempLong, subFile[i]);
		  }
			//  System.out.println("最近的一个文件的路径-->"+tm.get(tm.lastKey()).getPath());
		  tm.get(tm.lastKey()).delete();
		  }	
		File ff=new File(targetpath);
		File[] files=ff.listFiles();
		for (int i=0;i<files.length;i++){
			alist.add(files[i].getName());
		}
	//	System.out.println(alist.size());
		BufferedReader br=new BufferedReader(new FileReader(sourcepath));
		int count=0;
		while (true){
			s=br.readLine();
			if (s==null){
				break;
			}else{
				ff=new File(s);
				count++;
				if (!alist.contains(ff.getName())){
				System.out.println(count+": "+s);
			boolean flag=false;
			 BufferedReader br1=new BufferedReader(new InputStreamReader(new FileInputStream(s), "UTF8"));
		       BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetpath+File.separator+ff.getName()), "UTF8"));
		   ArrayList lines=new ArrayList();
		   int lineLength=0;
			while (true){
			s=br1.readLine();
			if (s==null){
			   break;
			}else{
				s=s.trim();
				 if (s.length()>0){
				  if (s.length()>=3000){
					if (lines.size()>0){
					/*	System.out.println("TYPE 1::::"+lineLength);
						
						for (int k=0;k<lines.size();k++){
							System.out.println(lines.get(k).toString());
						} */
						int size=lines.size();
					    String[] array = (String[])lines.toArray(new String[size]);
					   	String[] result = GetArrayTranslations(array, SL, TL);
				//	    String[] result = ObtainArrayTrans(array, SL, TL);
				//	   	Thread.sleep(500);
					   	 if (result==null){
					   		 flag=true;
					   	 }else{
					   	for (int k=0;k<result.length;k++){
					//    	System.out.println(result[k]);
							bw.write(result[k]);
							bw.newLine();
					    			}
					   	 }
					lines.clear();
					lineLength=0;
					} 
					ArrayList chunk=new ArrayList();
					chunks(chunk,s,2000);
					String res="";
					String candidate="";
					for (int j=0;j<chunk.size();j++){
						String segment=chunk.get(j).toString();
						if ((lineLength+segment.length())<3000){
							lines.add(segment);
							lineLength=lineLength+segment.length();
						}else{
							int size=lines.size();
						/*	System.out.println("TYPE 2::::"+lineLength);
							for (int k=0;k<lines.size();k++){
							//	System.out.println(lines.get(k).toString());
								candidate=candidate+lines.get(k).toString()+" ";
							} */
				    		String[] array = (String[])lines.toArray(new String[size]);
				    		String[] result = GetArrayTranslations(array, SL, TL);
				    		//Thread.sleep(500);
				    		if (result==null){
				    			flag=true;	
				    		}else{
				    		for (int k=0;k<result.length;k++){
				    			res=res+result[k]+" ";
				    		} 
				    		}
				    		lines.clear();
				    		lines.add(segment);
				    		lineLength=segment.length();
						}
					}
					if (lines.size()>0){
				/*		System.out.println("TYPE 3::::"+lineLength);
						
						for (int k=0;k<lines.size();k++){
						//	System.out.println(lines.get(k).toString());
							candidate=candidate+lines.get(k).toString()+" ";
						} */
						int size=lines.size();
			    		String[] array = (String[])lines.toArray(new String[size]);
			    		String[] result = GetArrayTranslations(array, SL, TL);
			    	//	Thread.sleep(500);
			    		if (result==null){
			    			flag=true;
			    			
			    		}else{
			    		for (int k=0;k<result.length;k++){
			    			res=res+result[k]+" ";
			    		} 
			    		}
			    //		System.out.println(candidate);
			    		bw.write(res);
			    		bw.newLine();
			    		lines.clear();
			    		lineLength=0;
					}		
				}
				else{
					  if ((lineLength+s.length())<3000){
					    	lines.add(s);
					    	lineLength=lineLength+s.length();
					    	}else{
					    		//System.out.println(lineLength);
					   	/*	System.out.println("TYPE 4::::"+lineLength);
					    	  	for (int k=0;k<lines.size();k++){
									    		System.out.println(lines.get(k).toString());
									 }  */
									int size=lines.size();
									String[] array = (String[])lines.toArray(new String[size]);
									String[] result = GetArrayTranslations(array, SL, TL);
									    //		String[] result = ObtainArrayTrans(array, SL, TL);
								//	Thread.sleep(500);
									if (result==null){
						    			flag=true;
						    			
						    		}else{
									for (int k=0;k<result.length;k++){
							   //	System.out.println(result[k]);
									bw.write(result[k]);
								 	bw.newLine();
									   	} 
						    		}
									 lines.clear();
									 lines.add(s);
									 lineLength=s.length();	
											//     Thread.sleep(1000);
					    		}
					    	}  
				 }
					}
					    }
			if (lineLength>0){
				/*	System.out.println("TYPE 5::::"+lineLength);
			   for (int k=0;k<lines.size();k++){
			     System.out.println(lines.get(k).toString());
			    	}  */
				int size=lines.size();
			    String[] array = (String[])lines.toArray(new String[size]);
			   	String[] result = GetArrayTranslations(array, SL, TL);
		//	    String[] result = ObtainArrayTrans(array, SL, TL);
			   	if (result==null){
	    			flag=true;
	    			
	    		}else{
			   	for (int k=0;k<result.length;k++){
			//    	System.out.println(result[k]);
					bw.write(result[k]);
					bw.newLine();
			    			} 
			}
					    }
			bw.flush();
			bw.close();
		    br1.close();
		   Thread.sleep(500);
		    if (flag==true){
		    	File wrongFile=new File(targetpath+File.separator+ff.getName());
		        wrongFile.delete();
		    }
			}
			}
				}
		 br.close();
		 ff=new File(targetpath);
		 files=ff.listFiles();
		 File f=new File(sourcepath);
		 BufferedWriter bw1=new BufferedWriter(new FileWriter(f.getParent()+File.separator+"arraytranslation-output.txt"));
		for (int i=0;i<files.length;i++){
			bw1.write(files[i].getAbsolutePath());
			bw1.newLine();
		}
		bw1.flush();
		bw1.close();
			System.out.println("Translation is all done!");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

				
}