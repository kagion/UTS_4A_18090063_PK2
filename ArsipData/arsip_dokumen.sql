-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Apr 2020 pada 18.11
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arsip_dokumen`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'member', 'aa08769cdcb26674c6706093503ff0a3');

-- --------------------------------------------------------

--
-- Struktur dari tabel `dokumen`
--

CREATE TABLE `dokumen` (
  `kode_dokumen` int(11) NOT NULL,
  `nama_dokumen` varchar(100) NOT NULL,
  `kategori_dokumen` varchar(50) NOT NULL,
  `lokasi_dokumen` varchar(100) NOT NULL,
  `deskripsi_dokumen` text NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `dokumen`
--

INSERT INTO `dokumen` (`kode_dokumen`, `nama_dokumen`, `kategori_dokumen`, `lokasi_dokumen`, `deskripsi_dokumen`, `tanggal`) VALUES
(180, 'apa', 'Surat  Keluar', 'C:UserskagionDownloadspaduana-removebg-preview (1).png', 'apa', '2020-04-23'),
(222, 'misal', 'Surat  Keluar', 'C:UserskagionDownloads936-2078-2-PB.doc', 'misal', '2020-04-23'),
(2222, 'duh', 'Surat Masuk ', 'C:UserskagionDownloadsCV.docx', 'duh', '2020-04-02'),
(3333, 'ccc', 'Surat  Keluar', 'G:absen.sql', 'ccccc', '2020-04-22'),
(5555, 'dddddd', 'Surat Ijin', 'G:D4 INFORMATIKASEMESTER 44A_18090063_SUGIONO.docx', 'ddddd', '2020-04-23'),
(6666, 'mmmm', 'Surat Ijin', 'G:D4 INFORMATIKASEMESTER 4PEMROGRAMAN-KOMPUTER4A_SUGIONO_18090063.zip', 'mmm', '2020-04-23');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `dokumen`
--
ALTER TABLE `dokumen`
  ADD PRIMARY KEY (`kode_dokumen`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT untuk tabel `dokumen`
--
ALTER TABLE `dokumen`
  MODIFY `kode_dokumen` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6667;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
