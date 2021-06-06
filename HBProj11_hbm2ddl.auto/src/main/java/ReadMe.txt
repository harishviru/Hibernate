[hbm2ddd.auto] ::
============
•SQL DDL Commands   are   :[Create,alter,truncate,drop,rename]= dr.cat

•In  the hibernate ,hbm2ddl.auto tells whether table in database need to be created or not.

• hbm2ddl.auto contains four values ,they are
                                                                          i)create 
                                                                         ii)update
                                                                         iii)validate
                                                                         iv)create-drop

#create ::
======
•  if the value is create than hibernate always create new table .. if table is present in database than it drop it and recreate it… 
     with that previous data in table is lost.
               <property name="hbm2ddl.auto">create</property>


#update::
=======
•  if value is update than hibernate first validate that table is present in database or not ,
                                                                                     if present used that table or 
                                                                                      if not create a new table.
               <property name="hbm2ddl.auto">update</property>


#validate ::
========
•   if value is validate than hibernate only verified that table is present or not. .if table is not exit than throws exception.

               <property name="hbm2ddl.auto">validate</property>

#create-drop ::
==========
• if value is create-drop than hibernate create a new table perform operation and delete that table immediately this value is used for               testing of the hibernate code.
                                         <property name="hbm2ddl.auto">create-drop</property>

Note ::
                                       *) sessionFactory   started........................!
                                         • drop table if exists <table_name>
                                         • create table
                                         • Do operation on Table
                                        *) sessionFactory   ended........................!
                                         • drop table if exists <table_name>