package derlin.symbiosart.jetty.rest;

/**
 * @author: Lucy Linder
 * @date: 26.12.2015
 */

import derlin.symbiosart.api.user.UserApi;
import derlin.symbiosart.pojo.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path( "/user" )
public class UsersService{

    private UserApi api = new UserApi();


    // curl http://localhost:8680/rest/user/all
    @GET
    @Path( "/all" )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public List<String> getNameList(){
        return api.getUsers();
    }


    // curl http://localhost:8680/rest/user
    @GET
    @Path( "/{id}" )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public User getUser( @PathParam( "id" ) String id ){
        return api.getUser( id );
    }


    // curl -X POST -H 'Content-Type:application/json' --data '{"name":"test","tags_vector":{"newyork":3,"sea":-1} }'
    // http://localhost:8680/rest/user
    @POST
    @Path( "/" )
    @Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public void addUser( User user ){
        api.addUser( user );
    }

    // curl -X POST -H 'Content-Type:application/json' --data '{"wedding": 2}' http://localhost:8000/rest/username
    @POST
    @Path( "/{id}" )
    @Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public boolean updateUser( @PathParam( "id" ) String id, User user ){
        return api.updateUser( id, user );
    }


    // curl -X DELETE  http://localhost:8000/rest/username
    @DELETE
    @Path( "/{id}" )
    @Produces( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
    public void deleteUser( @PathParam( "id" ) String id ){
        api.removeUser( id );
    }


}//end class
