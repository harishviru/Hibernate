 #Case 1 :
/* If object is not associted with session,
  *                                 i)If object/record Id not exist in DB ,then merge() method will insert record.
 *                                 ii) If object/record Id  exist in DB,then merge() method will update record
 */
 #Case 2 :
/* If object is  associted with session,
  *                                  i) Then merge() method (object state will merged) will update record                       
 */

When we to use update and merge methods ?
=================================

• Update method the persistent instance with the identifier of the given detached instance.
   If there is a persistent instance with the same  identifier, an exception is thrown. Then we can use merge() method

# Update    ::
                if you are sure that the session DOES NOT contains an already persistent instance with same identifier,then we can use
                update() method to save the data in Database

#merge      ::
                if you want to save your modifications at any time without knowing about the state of session ,then we can use
                 merge()  method.
