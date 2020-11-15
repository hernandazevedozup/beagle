/*
 * Copyright 2020 ZUP IT SERVICOS EM TECNOLOGIA E INOVACAO SA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.zup.beagle.automatedtests.model

import java.util.*

data class Book(
    val title: String = "",
    val author: String = "",
    val year: Int? = null,
    val collection: String? = null,
    val bookNumber: Int? = null,
    val genre: String? = null,
    val rating: Double? = null,
    val characters: List<String>? = null
) {
    constructor(
        title: String,
        author: String
    ) : this(
        title = title,
        author = author,
        characters = Character.createMock(title)
    )

    companion object {
        fun createMockByCategory(category: Int): List<Book> {
            val bookList = ArrayList<Book>()

            when (category) {
                1 -> {
                    var book = Book(title = "The Final Empire", author = "Brandon Sanderson")
                    bookList.add(book)

                    book = Book(title = "The Alloy of Law", author = "Brandon Sanderson")
                    bookList.add(book)

                    book = Book(title = "A Game of Thrones", author = "George R.R. Martin")
                    bookList.add(book)

                    book = Book(title = "Words of Radiance", author = "Brandon Sanderson")
                    bookList.add(book)

                    book = Book(title = "Shadows Rising", author = "Madeleine Roux")
                    bookList.add(book)

                    book = Book(title = "Before the Storm", author = "Christie Golden")
                    bookList.add(book)

                    book = Book(title = "Harry Potter and the Philosopher's Stone", author = "Harry Potter and the Philosopher's Stone")
                    bookList.add(book)
                }
                2 -> {
                    var book = Book(title = "Starsight", author = "Brandon Sanderson")
                    bookList.add(book)

                    book = Book(title = "Heaven's River", author = "Dennis E. Taylor")
                    bookList.add(book)

                    book = Book(title = "Leviathan Wakes", author = "James S.A. Corey")
                    bookList.add(book)

                    book = Book(title = "Dune", author = "Frank Herbert")
                    bookList.add(book)

                    book = Book(title = "Dying of the Light", author = "George R.R. Martin")
                    bookList.add(book)
                }
                3 -> {
                    var book = Book(title = "The Last Tribe", author = "Brad Manuel")
                    bookList.add(book)

                    book = Book(title = "The Cuckoo's Cry", author = "Caroline Overington")
                    bookList.add(book)

                    book = Book(title = "The Handmaid's Tale", author = "Margaret Atwood")
                    bookList.add(book)
                }
            }

            return bookList
        }

        fun createMockByPage(page: Int): List<Book> {
            val bookList = ArrayList<Book>()

            when (page) {
                1 -> {
                    var book = Book(title = "The Final Empire", author = "Brandon Sanderson", year = 2006, collection = "Mistborn Era 1", bookNumber = 1, genre = "Fantasy", rating = 4.7)
                    bookList.add(book)

                    book = Book(title = "The Alloy of Law", author = "Brandon Sanderson", year = 2011, collection = "Mistborn Era 2", bookNumber = 1, genre = "Fantasy", rating = 4.5)
                    bookList.add(book)

                    book = Book(title = "A Game of Thrones", author = "George R.R. Martin", year = 1996, collection = "A Song of Ice and Fire", bookNumber = 1, genre = "Fantasy", rating = 4.8)
                    bookList.add(book)

                    book = Book(title = "Words of Radiance", author = "Brandon Sanderson", year = 2014, collection = "The Stormlight Archive", bookNumber = 2, genre = "Fantasy", rating = 4.8)
                    bookList.add(book)

                    book = Book(title = "Shadows Rising", author = "Madeleine Roux", year = 2020, collection = "World of Warcraft", bookNumber = 24, genre = "Fantasy", rating = 4.3)
                    bookList.add(book)
                }
                2 -> {
                    var book = Book(title = "Before the Storm", author = "Christie Golden", year = 2018, collection = "World of Warcraft", bookNumber = 23, genre = "Fantasy", rating = 4.6)
                    bookList.add(book)

                    book = Book(title = "Harry Potter and the Philosopher's Stone", year = 1997, author = "Harry Potter and the Philosopher's Stone", collection = "Harry Potter", bookNumber = 1, genre = "Fantasy", rating = 4.9)
                    bookList.add(book)

                    book = Book(title = "Starsight", author = "Brandon Sanderson", year = 2019, collection = "Skyward", bookNumber = 2, genre = "Sci-fi", rating = 4.8)
                    bookList.add(book)

                    book = Book(title = "Heaven's River", author = "Dennis E. Taylor", year = 2020, collection = "Bobiverse", bookNumber = 4, genre = "Sci-fi", rating = 4.8)
                    bookList.add(book)

                    book = Book(title = "Leviathan Wakes", author = "James S.A. Corey", year = 2015, collection = "The Expanse", bookNumber = 1, genre = "Sci-fi", rating = 4.7)
                    bookList.add(book)
                }
                3 -> {
                    var book = Book(title = "Dune", author = "Frank Herbert", year = 1965, collection = "Dune", bookNumber = 1, genre = "Sci-fi", rating = 4.6)
                    bookList.add(book)

                    book = Book(title = "Dying of the Light", author = "George R.R. Martin", year = 1976, genre = "Sci-fi", rating = 4.1)
                    bookList.add(book)

                    book = Book(title = "The Last Tribe", author = "Brad Manuel", year = 2016, genre = "Other", rating = 4.3)
                    bookList.add(book)

                    book = Book(title = "The Cuckoo's Cry", author = "Caroline Overington", year = 2020, genre = "Other", rating = 4.3)
                    bookList.add(book)

                    book = Book(title = "The Handmaid's Tale", author = "Margaret Atwood", year = 1985, collection = "The Handmaid's Tale", bookNumber = 1, genre = "Other", rating = 4.6)
                    bookList.add(book)
                }
            }

            return bookList
        }
    }
}

data class BookResponse(
    val currentPage: Int,
    val totalPages: Int,
    val result: List<Book>
) {
    companion object {
        fun createMock(page: Int): BookResponse {
            return BookResponse(page, 3, Book.createMockByPage(page))
        }
    }
}