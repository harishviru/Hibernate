[Composite Id]::
============
• Process of defining primary on more than on column is called composite id.
• It means combination of columns should not be generated.

IN XML ::
                     <composite-id>
                                   <key-property name="employeeId" column="emp_id"/>
                                   <key-property name="employeeName" column="emp_name"/>
                      </composite-id>



IN Annotation :: We can use @IdClass ,@EmbeddedId

#01 :@IdClass

@IdClass(BookAnnoComPk01.class)
@Entity
@Table(name="book_anno")
public class BookAnno01 implements Serializable {

	@Id
	private int isbn;               
	@Id
        private String bookName; 

}
BookAnnoComPk01.class
-----------------------------------
@Data
public class BookAnnoComPk01 implements Serializable {
     private int isbn;               //International Standard Book Number
    private String bookName;
	
}

#02 ::@EmbeddedId

@Data
@Entity
@Table(name="book_anno")
public class BookAnno02 implements Serializable {

  @EmbeddedId
   private BookAnnoComPk02 comPk;
    private String authorName;
    private String category;
    private Double price;
	
}

BookAnnoComPk02.class    
 --------------------------------   
@Data
@Embeddable
public class BookAnnoComPk02 implements Serializable {

   private int isbn;               //International Standard Book Number
    private String bookName;	
	
}