package exercises.contact_form.service;

import exercises.contact_form.dao.ContactRepo;
import exercises.contact_form.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService  implements ContactServiceInterface {

    private ContactRepo contactRepo;

    @Autowired
    public ContactService(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public Contact saveContactToDatabase(Contact contact) {
        return contactRepo.save(contact);
    }
}
