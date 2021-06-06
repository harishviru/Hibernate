package com.har.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.har.entity.Product;
import com.har.entity.ProductAnno;
import com.har.utility.HibernateUtil;

//hbm2ddl.auto test
public class Hbm2DLLAutoAnnoTest {

	public static void main(String[] args) {
		//createDDLAUTOTest();	
		createDDLAUTOAnnoTest();
	}

	/**
	 * 
	 *  Here  we are using ---> <property name="hbm2ddl.auto">create/update/validate/create-drop</property>
	 *  
	 */
	@SuppressWarnings("unused")
	private static void createDDLAUTOTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Boolean flag                        = false;
		Product product                 = null;
		
		  try {
			    //Create product obj
			  product = new Product();
			  product.setProductName("MX Mobile");
			  product.setProdPrice(9000.0);
			  
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			   txn=session.beginTransaction();			
			   Integer id = (Integer) session.save(product);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully saved product object with id   ::"+id);
			   
		} catch (Exception e) {
			e.printStackTrace();
			 if(!flag){
				 txn.rollback();
			 }
		}finally {
			    if(flag && session.isOpen()){             // Close Session and SessionFactory
			    	HibernateUtil.closeSession(session);
			    	HibernateUtil.closeSessionFactory();
			    }
		}
	}
	
	private static void createDDLAUTOAnnoTest() {
		Session       session              = null;
		Transaction     txn                = null;
		Boolean flag                        = false;
		ProductAnno product        = null;
		
		  try {
			    //Create product obj
			  product = new ProductAnno();
			  product.setProductName("Nokia Mobile");
			  product.setProdPrice(1200.0);
			  
			   //get HB session Object
			   session   = HibernateUtil.getSession();
			   txn=session.beginTransaction();			
			   Integer id = (Integer) session.save(product);
			   txn.commit();
			   flag =true;
			   System.out.println("successfully saved product object with id   ::"+id);
			   
		} catch (Exception e) {
			e.printStackTrace();
			 if(!flag){
				 txn.rollback();
			 }
		}finally {
			    if(flag && session.isOpen()){             // Close Session and SessionFactory
			    	HibernateUtil.closeSession(session);
			    	HibernateUtil.closeSessionFactory();
			    }
		}
	}
	
}
