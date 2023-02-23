# GraphQLCountries

A simple application for displaying country information using [Apollo Client](https://www.apollographql.com/docs/kotlin/) and [Jetpack Compose](https://developer.android.com/jetpack/compose/).

## What is GraphQL?

GraphQL is an open-source query language and runtime for APIs (Application Programming Interfaces) that was developed by Facebook. It was created to solve some of the limitations of REST APIs, such as overfetching, underfetching, and the need to make multiple API requests to get related data.

One of the key benefits of GraphQL is that it enables clients to specify exactly what data they need, and the server responds with a JSON object containing only that data. This allows for more efficient data fetching and reduces the amount of data transferred over the network. Additionally, GraphQL provides a strongly-typed schema that defines what data can be queried and how it can be modified, which can help improve the overall development experience.

GraphQL also provides powerful features such as the ability to query multiple resources in a single request, real-time updates using subscriptions, and introspection, which allows clients to query the schema and discover the available data.

## GraphQL VS REST
REST (Representational State Transfer) API and GraphQL are both popular technologies used for building APIs (Application Programming Interfaces) that allow communication between different software systems.

REST is a well-established standard that uses HTTP methods (such as GET, POST, PUT, DELETE) to manipulate resources exposed by a server. It emphasizes statelessness, which means that each request to the server should contain all the necessary information to complete that request, without relying on server-side state. REST APIs return data in a structured format like JSON or XML.

GraphQL, on the other hand, is a newer technology that provides a more flexible way to query data from APIs. Instead of making multiple requests for related data, a client can send a single GraphQL query that specifies exactly what data it needs, and the server responds with a JSON object containing only that data. This reduces overfetching and underfetching, two common issues with REST APIs. Additionally, GraphQL provides a strongly-typed schema that defines what data can be queried and how it can be modified.

In summary, REST APIs are good for exposing resources that follow a standard CRUD (Create, Read, Update, Delete) pattern, while GraphQL provides a more flexible and efficient way to query and modify data.


Here is the GraphQL and REST comparison table:
<img src="https://user-images.githubusercontent.com/94696816/220876791-c8788475-ddb8-46ba-9578-87efc8608972.png" width="700" height="500" />

## Technologies
- **UI** - [Jetpack Compose](https://developer.android.com/jetpack/compose) ([Material3](https://m3.material.io/))
- **DI** - [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Architecture pattern** - [MVI](https://medium.com/swlh/mvi-architecture-with-android-fcde123e3c4a)
- **Networking** - [Apollo GraphQL](https://www.apollographql.com/)

## Screenshots
<img src="https://user-images.githubusercontent.com/94696816/220880850-38036367-5be9-4a32-be17-bb3297517864.png" width="200" height="400" />
<img src="https://user-images.githubusercontent.com/94696816/220881022-59c7a157-f00d-44e9-af7b-906ea649f31f.png" width="200" height="400" />
