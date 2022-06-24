---
# ? Sections are overarching outlines of related booklets.
define-section:
  - alias: section:learn
    order: 0
    caption: Learn

  - alias: section:design
    order: 1
    caption: Design

# ? Individual chapters and pages are bound together in booklets.
define-booklet:
  # ?
  - alias: booklet:code-lab
    route: code-lab
    order: 0
    section: section:learn
    caption: Code Lab

  # ?
  - alias: booklet:design-system
    route: design-system
    order: 0
    section: section:design
    caption: Design System

# ? Chapters are independent of, and can be used in multiple, booklets and
#   can be used to categorize sections.
define-chapter:
  - alias: chapter:structure
    route: structure
    order: 0
    caption: Structure

  - alias: chapter:layout
    route: layout
    order: 1
    caption: Layout

  - alias: chapter:components
    route: components
    order: 2
    caption: Components

  - alias: chapter:color
    route: color
    order: 3
    caption: Color
---

<!-- this file is intentionally left blank -->
