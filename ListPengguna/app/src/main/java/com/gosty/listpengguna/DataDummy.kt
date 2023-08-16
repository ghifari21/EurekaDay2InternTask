package com.gosty.listpengguna

object DataDummy {
    fun provideDataDummy(): List<UserModel> =
        listOf(
            UserModel(
                id = 1,
                photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtSkgu4vpKIbdsXhTE2smxfryqKhRmYjknp-m79bF5&s",
                name = "Danny",
                email = "danny@email.com",
                jurusan = "Ilmu Komputer",
                semester = 4
            ),
            UserModel(
                id = 2,
                photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtSkgu4vpKIbdsXhTE2smxfryqKhRmYjknp-m79bF5&s",
                name = "Johnny",
                email = "johnny@email.com",
                jurusan = "Ilmu Komunikasi",
                semester = 2
            ),
            UserModel(
                id = 3,
                photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtSkgu4vpKIbdsXhTE2smxfryqKhRmYjknp-m79bF5&s",
                name = "Melvyn",
                email = "melvyn@email.com",
                jurusan = "Fisika",
                semester = 6
            ),
            UserModel(
                id = 4,
                photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtSkgu4vpKIbdsXhTE2smxfryqKhRmYjknp-m79bF5&s",
                name = "Hilman",
                email = "hilman@email.com",
                jurusan = "Matematika",
                semester = 8
            ),
            UserModel(
                id = 5,
                photo = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtSkgu4vpKIbdsXhTE2smxfryqKhRmYjknp-m79bF5&s",
                name = "Alvin",
                email = "alvin@email.com",
                jurusan = "Multimedia",
                semester = 6
            )
        )
}