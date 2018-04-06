This NetBeans plugin will automatically remove the AltGraph code from all KeyEvents.
In Java9 the AltGraph code was added in Windows but this key has the same scancode as the right Alt (VK_RMENU).
This change causes the right Alt to have an extra bit set which causes hotkeys to stop working.
See Java bug : https://bugs.java.com/bugdatabase/view_bug.do?bug_id=JDK-8194873
Also see : https://en.wikipedia.org/wiki/AltGr_key

