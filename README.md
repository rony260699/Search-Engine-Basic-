# Search-Engine-Basic-

A basic search engine built from scratch in Java, implementing all core components including **crawling**, **indexing**, **ranking (using DFS)**, and **search history tracking**. The engine uses **MySQL** for backend data management and is designed as a portfolio project to demonstrate foundational concepts of search engines.

## 🚀 Features

- **Web Crawler**: Traverses the web using HTTP requests to gather content from web pages.
- **Indexing**: Parses HTML content and builds an inverted index for fast lookup.
- **Ranking Algorithm**: Uses **Depth-First Search (DFS)** based relevance ranking of documents.
- **Search History**: Maintains user search queries with timestamps.
- **Database Integration**: Uses **MySQL** to store crawled data, indexes, and user history.
- **Console-Based UI**: Interact with the engine via a simple web interface

## ⚙️ Technologies Used

- **Java**
- **MySQL**
- **JDBC** (Java Database Connectivity)
- **HTML Parsing**
  
🔍 How It Works

Crawling: Starts from a seed URL and visits linked pages recursively.

Indexing: Extracts words from HTML content and stores term-document mapping.

Ranking: DFS is used to traverse linked pages and rank based on depth/relevance.

History: Logs each search term and timestamp for user reference or analytics.
## Screenshots
![Screenshot (80)](https://github.com/user-attachments/assets/0796f6de-b97d-4444-963c-306ca1052c10)
![Screenshot (79)](https://github.com/user-attachments/assets/5a5066cf-5789-4b03-80ae-49aef18d4f5c)

