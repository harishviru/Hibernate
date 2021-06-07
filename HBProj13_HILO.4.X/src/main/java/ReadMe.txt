hilo                            :: TableHiloGenerator 
=====
• This generator class generates id for an object when first time as one (1),From second time onwards,the id will
    be generated using max_lo+next_hi+next_hi.

•  When hilo generator is configured for <id/> tag then hibernate excepts three parameters configures along with hilo generator
                                                                 1) Table
                                                                 2)Column
                                                                 3)Max_lo

• When parameters are not configured,then hibernate consider default values are..
                                                                 1) Table                    : hibernate_unique_key
                                                                 2)Column                 :next_hi
                                                                 3)Max_lo                   :32767                             

•                                   Hilo generator formula :  max_lo * next_hi +next_hi 

• ex :#1   
       <id name="studentId" column="sid">
                 <generator class="hilo"/>
        </id>
                
          #2
          <id name="studentId" column="sid">
                   <generator class="hilo">
                          <param name="max_lo">10</param>
                   </generator>
           </id>
              
             #3
               <id name="studentId" column="sid">
                          <generator class="hilo">
                                  <param name="table">mytable</param>
                                   <param name="column">col1</param>
                                    <param name="max_lo">10</param>
                           </generator>
                  </id>
