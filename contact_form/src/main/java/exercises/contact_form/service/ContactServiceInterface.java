package exercises.contact_form.service;

import exercises.contact_form.entity.Contact;

public interface ContactServiceInterface {

    Contact  saveContactToDatabase(Contact contact);
}
