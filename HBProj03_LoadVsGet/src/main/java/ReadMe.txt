iii) get ::
              		<T> T get(Class<T> entityType, Serializable id);
iv)load ::
                   	<T> T load(Class<T> theClass, Serializable id);

                                            load                                                                          ||                                            Get
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  • It is used to fetch data from the database for the given identifier    |    • It is used to fetch data from the database for the given identifier
  • It returns proxy object [lazy loading]                                                        |     •It returns fully initialized object [Eager loading]              
 • If object not found ,it throw ObjectNotFoundException                       |     • If object not found ,it return null

Usecase ::
 •If we are sure object exists in DB,then we can use load method          | •If we are not sure object exists in DB,then we can use get method