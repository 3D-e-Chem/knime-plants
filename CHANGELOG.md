# Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).
The file is formatted as described on http://keepachangelog.com/.

## [Unreleased]

## [0.3.5] 2019-06-27

### Changes

- Requires KNIME 4.0 [#14](https://github.com/3D-e-Chem/knime-plants/issues/14)

## [0.3.4] 2018-02-07

### Fixed

* On KNIME startup a PLANTS error appears (#13)

## [0.3.3] 2017-11-08

### Fixed

* PLANTS is running in the background after cancellation (#12)

## [0.3.2] 2017-09-26

### Added

* Bundle PLANTS executable for Windows 32bit (#11)

## [0.3.1] 2017-09-05

### Fixed

* Make write_protein_splitted configurable [#10]

## [0.3.0] 2017-08-23

### Added

* Bundle PLANTS executable for Windows, Linux and MacOSX (#8)
* More fields for PLANTS configuration generator node

### Changed

* Runner writes stdout.txt and stderr.txt files

## [0.2.0] 2017-03-08

### Added

* Metanode to read PLANTS configuration file
* Metanode to execute PLANTS (#3)
* Metanode to read PLANTS virtual screening results (#4)

### Changed

* All nodes can be run with multiple input rows

### Fixed

* PLANTS executable in preference page is not adjustable (#7)

## [0.0.13] 2016-12-13

### Added

* Node to write PLANTS configuration file (#1)
* Metanode to create PLANTS session directory (#5)
