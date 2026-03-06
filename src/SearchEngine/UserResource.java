package SearchEngine;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/users")
public class UserResource {

	private UserDatabase userDB = UserDatabase.getInstance();

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response registerUser(RegisteredUser user) {
		System.out.println("API: Registering " + user.getUsername());
		UserDatabase.getInstance().addUser(user);
		return Response.status(Response.Status.CREATED).entity("User registered").build();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") String id) {
		// Using the Singleton Database
		RegisteredUser user = UserDatabase.getInstance().getUser(id);

		if (user != null) {
			return Response.ok(user).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") String id) {
		System.out.println("API: Deleting user " + id);

		// Checking if user exists first
		RegisteredUser user = UserDatabase.getInstance().getUser(id);
		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		// Removing user using existing UserDatabase method
		UserDatabase.getInstance().removeUser(id);

		return Response.ok("User deleted").build();
	}

	@POST
	@Path("/{id}/bookmarks")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addBookmark(@PathParam("id") String id, Bookmark bookmark) {

		RegisteredUser user = UserDatabase.getInstance().getUser(id);

		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
		}

		user.addBookmark(bookmark);

		System.out.println("API: Saved bookmark for " + id + ": " + bookmark.getUrl());
		return Response.ok("Bookmark added").build();
	}

	@GET
	@Path("/{id}/bookmarks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserBookmarks(@PathParam("id") String id) {

		RegisteredUser user = UserDatabase.getInstance().getUser(id);

		if (user == null) {
			return Response.status(Response.Status.NOT_FOUND).entity("User not found").build();
		}

		return Response.ok(user.getBookmarks()).build();
	}
}