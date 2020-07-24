> "I don't like that man. I must get to know him better."

I don't like "enterprise" Java frameworks.
They have been a source of frustration since I first encountered them during College.
Recently I've had to interface with such a framework at work, so I set out to understand and document what goes on behind the scenes (aka the source of my frustration).

The framework in question here is Spring, and I've used the Spring Boot initializer to set up a project to do simple CRUD.

My opinion still largely remains the same, but I now also see the appeal.
I've documented most of my views in the code itself, and there's more below. 

### Misc ~~rant~~ notes

- **Dependencies interfere even if you don't use them** - Interfacing with a database system requires `spring-boot-starter-data-jpa` (you can see it in the `pom.xml`).
What I found surprising was that the application wouldn't run if I did not configure the database.
This is even if I'm not actually using the db in my application!
Just having the dependency mandates me to configure a datastore. Not intuitive.
Granted this is not framework specific, but not a good start.
- **Annotations are too much magic** - Much of the framework seems to be driven by annotations (`@SomeThing`).
These are akin to Python's decorators, but I find that they abstract away too much here.
I am a proponent of "Explicit is better than implicit", and there's just too much happening implicitly in this framework.
From automatic serialization (and deserialization) of requests to defining search against the db.
Apparently the magic is much appreciated by some folk and seen as an advantage, but I am in the other bucket.
I want more control and to be able to see what's going on by reading the code and not having to remember the framework's default behaviour in all scenarios.
- **Poor defaults** - Data persistence is taken care of by JPA and Hibernate -
where all fields are nullable by default and migrations (schema changes) are performed on a best effort basis.
Database migrations seem to be a second-class citizen as the framework doesn't generate any migration files or logs.
There are third-party libraries that give you more control over db migrations, but then why am I using this "framework"?

I haven't even scratched the surface, but I think I've seen enough for now.
